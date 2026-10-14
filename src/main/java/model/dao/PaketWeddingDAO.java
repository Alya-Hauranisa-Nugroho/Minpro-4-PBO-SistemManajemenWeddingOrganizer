package model.dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PaketWedding;
import view.Pesan;

public class PaketWeddingDAO {

    public boolean tambahPaket(PaketWedding pw) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "INSERT INTO paket_wedding (id_paket, nama_paket, harga) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pw.getIdPaket());
            pstmt.setString(2, pw.getNamaPaket());
            pstmt.setInt(3, pw.getHarga());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menambah paket: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<PaketWedding> ambilSemuaPaket() {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        ArrayList<PaketWedding> daftar = new ArrayList<>();
        String sql = "SELECT * FROM paket_wedding ORDER BY id_paket";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                daftar.add(new PaketWedding(rs.getInt("id_paket"),
                        rs.getString("nama_paket"), rs.getInt("harga")));
            }
            return daftar;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengambil data paket: " + e.getMessage());
            return null;
        }
    }

    public PaketWedding cariById(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        String sql = "SELECT * FROM paket_wedding WHERE id_paket = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new PaketWedding(rs.getInt("id_paket"),
                            rs.getString("nama_paket"), rs.getInt("harga"));
                }
            }
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mencari paket: " + e.getMessage());
        }
        return null;
    }

    public boolean updateHarga(int idPaket, int harga) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "UPDATE paket_wedding SET harga=? WHERE id_paket=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, harga);
            pstmt.setInt(2, idPaket);

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengubah harga paket: " + e.getMessage());
        }
        return false;
    }

    public boolean hapusPaket(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "DELETE FROM paket_wedding WHERE id_paket=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menghapus paket: " + e.getMessage());
        }
        return false;
    }
}