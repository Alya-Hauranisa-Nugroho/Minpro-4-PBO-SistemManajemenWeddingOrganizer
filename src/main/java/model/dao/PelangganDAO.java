package model.dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pelanggan;
import view.Pesan;

public class PelangganDAO {

    public boolean tambahPelanggan(Pelanggan p) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "INSERT INTO pelanggan (id_pelanggan, nama, no_hp) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, p.getIdPelanggan());
            pstmt.setString(2, p.getNama());
            pstmt.setString(3, p.getNoHp());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menambah pelanggan: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Pelanggan> ambilSemuaPelanggan() {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        ArrayList<Pelanggan> daftar = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan ORDER BY id_pelanggan";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                daftar.add(new Pelanggan(rs.getInt("id_pelanggan"),
                        rs.getString("nama"), rs.getString("no_hp")));
            }
            return daftar;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengambil data pelanggan: " + e.getMessage());
            return null;
        }
    }

    public Pelanggan cariById(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Pelanggan(rs.getInt("id_pelanggan"),
                            rs.getString("nama"), rs.getString("no_hp"));
                }
            }
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mencari pelanggan: " + e.getMessage());
        }
        return null;
    }

    public boolean updatePelanggan(Pelanggan p) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "UPDATE pelanggan SET nama=?, no_hp=? WHERE id_pelanggan=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getNama());
            pstmt.setString(2, p.getNoHp());
            pstmt.setInt(3, p.getIdPelanggan());

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengubah pelanggan: " + e.getMessage());
        }
        return false;
    }

    public boolean hapusPelanggan(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menghapus pelanggan: " + e.getMessage());
        }
        return false;
    }
}