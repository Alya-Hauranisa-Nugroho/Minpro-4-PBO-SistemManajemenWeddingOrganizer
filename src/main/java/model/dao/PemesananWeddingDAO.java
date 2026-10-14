package model.dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import model.PaketWedding;
import model.Pelanggan;
import model.PemesananWedding;
import view.Pesan;

public class PemesananWeddingDAO {

    public static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);

    private static final String SELECT_DASAR =
            "SELECT b.id_booking, b.venue, b.tanggal_acara, b.pax, "
            + "p.id_pelanggan, p.nama, p.no_hp, k.id_paket, k.nama_paket, k.harga "
            + "FROM pemesanan_wedding b "
            + "JOIN pelanggan p ON b.id_pelanggan = p.id_pelanggan "
            + "JOIN paket_wedding k ON b.id_paket = k.id_paket ";

    public boolean tambahPemesanan(PemesananWedding b) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "INSERT INTO pemesanan_wedding "
                + "(id_booking, id_pelanggan, id_paket, venue, tanggal_acara, pax) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, b.getIdBooking());
            pstmt.setInt(2, b.getPelanggan().getIdPelanggan());
            pstmt.setInt(3, b.getPaketWedding().getIdPaket());
            pstmt.setString(4, b.getVenue());
            pstmt.setDate(5, Date.valueOf(LocalDate.parse(b.getTanggalAcara(), FMT)));
            pstmt.setInt(6, b.getPax());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menambah pemesanan: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<PemesananWedding> ambilSemuaPemesanan() {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        ArrayList<PemesananWedding> daftar = new ArrayList<>();
        String sql = SELECT_DASAR + "ORDER BY b.id_booking";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                daftar.add(mapRow(rs));
            }
            return daftar;
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengambil data pemesanan: " + e.getMessage());
            return null;
        }
    }

    public PemesananWedding cariById(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return null;
        String sql = SELECT_DASAR + "WHERE b.id_booking = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mencari pemesanan: " + e.getMessage());
        }
        return null;
    }

    public boolean updatePemesanan(PemesananWedding b) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "UPDATE pemesanan_wedding SET venue=?, tanggal_acara=?, pax=? WHERE id_booking=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, b.getVenue());
            pstmt.setDate(2, Date.valueOf(LocalDate.parse(b.getTanggalAcara(), FMT)));
            pstmt.setInt(3, b.getPax());
            pstmt.setInt(4, b.getIdBooking());

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Booking tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal mengubah pemesanan: " + e.getMessage());
        }
        return false;
    }

    public boolean hapusPemesanan(int id) {
        Connection conn = Koneksi.getConnection();
        if (conn == null) return false;
        String sql = "DELETE FROM pemesanan_wedding WHERE id_booking=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            if (pstmt.executeUpdate() > 0) return true;
            Pesan.tampilkanPesan("ID Booking tidak ditemukan :(");
        } catch (SQLException e) {
            Pesan.tampilkanPesan("Gagal menghapus pemesanan: " + e.getMessage());
        }
        return false;
    }

    private PemesananWedding mapRow(ResultSet rs) throws SQLException {
        Pelanggan pelanggan = new Pelanggan(rs.getInt("id_pelanggan"),
                rs.getString("nama"), rs.getString("no_hp"));
        PaketWedding paket = new PaketWedding(rs.getInt("id_paket"),
                rs.getString("nama_paket"), rs.getInt("harga"));
        String tanggal = rs.getDate("tanggal_acara").toLocalDate().format(FMT);

        return new PemesananWedding(rs.getInt("id_booking"), pelanggan, paket,
                rs.getString("venue"), tanggal, rs.getInt("pax"));
    }
}