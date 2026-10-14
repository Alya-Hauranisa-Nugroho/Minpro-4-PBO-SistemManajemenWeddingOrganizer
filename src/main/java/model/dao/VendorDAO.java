package model.dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Vendor;
import model.VendorCatering;
import model.VendorDekorasi;
import view.Pesan;

public class VendorDAO {

    private static final String SELECT_DASAR =
            "SELECT v.id_vendor, v.nama_vendor, v.no_telepon, v.jenis_vendor, "
            + "c.jenis_masakan, c.sistem_penyajian, c.harga_per_pax, "
            + "d.tema_dekorasi, d.jenis_dekorasi, d.harga_paket_dekorasi "
            + "FROM vendor v "
            + "LEFT JOIN vendor_catering c ON v.id_vendor = c.id_vendor "
            + "LEFT JOIN vendor_dekorasi d ON v.id_vendor = d.id_vendor ";

    public boolean tambahVendor(Vendor v) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;

        try {
            conn.setAutoCommit(false);
            try {
                String sqlVendor = "INSERT INTO vendor (id_vendor, nama_vendor, no_telepon, jenis_vendor) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sqlVendor)) {
                    pstmt.setInt(1, v.getIdVendor());
                    pstmt.setString(2, v.getNamaVendor());
                    pstmt.setString(3, v.getNoTelepon());
                    pstmt.setString(4, v.getJenisVendor());
                    pstmt.executeUpdate();
                }

                if (v instanceof VendorCatering) {
                    VendorCatering vc = (VendorCatering) v;
                    String sql = "INSERT INTO vendor_catering (id_vendor, jenis_masakan, sistem_penyajian, harga_per_pax) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, vc.getIdVendor());
                        pstmt.setString(2, vc.getJenisMasakan());
                        pstmt.setString(3, vc.getSistemPenyajian());
                        pstmt.setInt(4, vc.getHargaPerPax());
                        pstmt.executeUpdate();
                    }
                } else if (v instanceof VendorDekorasi) {
                    VendorDekorasi vd = (VendorDekorasi) v;
                    String sql = "INSERT INTO vendor_dekorasi (id_vendor, tema_dekorasi, jenis_dekorasi, harga_paket_dekorasi) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, vd.getIdVendor());
                        pstmt.setString(2, vd.getTemaDekorasi());
                        pstmt.setString(3, vd.getJenisDekorasi());
                        pstmt.setInt(4, vd.getHargaPaketDekorasi());
                        pstmt.executeUpdate();
                    }
                }
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();  
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menambah vendor: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Vendor> ambilSemuaVendor(String jenis) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        ArrayList<Vendor> daftar = new ArrayList<>();
        String sql = SELECT_DASAR + (jenis == null ? "" : "WHERE v.jenis_vendor = ? ")
                + "ORDER BY v.id_vendor";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (jenis != null) pstmt.setString(1, jenis);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    daftar.add(mapRow(rs));
                }
            }
            return daftar;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengambil data vendor: " + e.getMessage());
            return null;
        }
    }

    public Vendor cariById(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        String sql = SELECT_DASAR + "WHERE v.id_vendor = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mencari vendor: " + e.getMessage());
        }
        return null;
    }

    public boolean updateHarga(Vendor v, int harga) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql;
        if (v instanceof VendorCatering) {
            sql = "UPDATE vendor_catering SET harga_per_pax=? WHERE id_vendor=?";
        } else {
            sql = "UPDATE vendor_dekorasi SET harga_paket_dekorasi=? WHERE id_vendor=?";
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, harga);
            pstmt.setInt(2, v.getIdVendor());

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Vendor tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengubah harga vendor: " + e.getMessage());
        }
        return false;
    }

    public boolean hapusVendor(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "DELETE FROM vendor WHERE id_vendor=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Vendor tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menghapus vendor: " + e.getMessage());
        }
        return false;
    }

    private Vendor mapRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_vendor");
        String nama = rs.getString("nama_vendor");
        String telp = rs.getString("no_telepon");

        if (rs.getString("jenis_vendor").equals("Catering")) {
            return new VendorCatering(id, nama, telp, rs.getString("jenis_masakan"),
                    rs.getString("sistem_penyajian"), rs.getInt("harga_per_pax"));
        }
        return new VendorDekorasi(id, nama, telp, rs.getString("tema_dekorasi"),
                rs.getString("jenis_dekorasi"), rs.getInt("harga_paket_dekorasi"));
    }
}