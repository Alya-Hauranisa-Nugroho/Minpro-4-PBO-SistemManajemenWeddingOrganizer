package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Cetakable;
import model.PaketWedding;
import model.Pelanggan;
import model.PemesananWedding;
import model.Vendor;
import model.VendorCatering;
import model.VendorDekorasi;
import model.dao.PaketWeddingDAO;
import model.dao.PelangganDAO;
import model.dao.PemesananWeddingDAO;
import model.dao.VendorDAO;
import view.Menu;
import view.Pesan;

public class WeddingCRUD {

    private final PelangganDAO pelangganDAO = new PelangganDAO();
    private final PaketWeddingDAO paketDAO = new PaketWeddingDAO();
    private final PemesananWeddingDAO pemesananWeddingDAO = new PemesananWeddingDAO();
    private final VendorDAO vendorDAO = new VendorDAO();
    private final Scanner scanner;

    public WeddingCRUD(Scanner scanner) {
        this.scanner = scanner;
    }

    // ===================== PELANGGAN =====================

    public void tambahPelanggan() {
        System.out.println("=====================================");
        System.out.println("|          TAMBAH PELANGGAN          |");
        System.out.println("=====================================");

        int id = InputValidator.bacaInt(scanner, "ID Pelanggan: ");
        if (pelangganDAO.cariById(id) != null) {
            Pesan.tampilkanPesan("Yaahh.. ID Pelanggan sudah dipakai :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Pelanggan: ");
        String noHp = InputValidator.bacaTeks(scanner, "No HP: ");

        if (pelangganDAO.tambahPelanggan(new Pelanggan(id, nama, noHp))) {
            Pesan.tampilkanPesan("YAYY!! Data pelanggan berhasil ditambahkan :D");
        }
    }

    public void tampilkanPelanggan() {
        System.out.println("=====================================");
        System.out.println("|          DAFTAR PELANGGAN          |");
        System.out.println("=====================================");

        ArrayList<Pelanggan> daftar = pelangganDAO.ambilSemuaPelanggan();
        if (daftar == null) return;   // error sudah ditampilkan DAO
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan :(");
            return;
        }
        for (Pelanggan p : daftar) {
            p.tampilkanInfo();
        }
    }

    public void updatePelanggan() {
        System.out.println("=====================================");
        System.out.println("|          UPDATE PELANGGAN          |");
        System.out.println("=====================================");

        ArrayList<Pelanggan> daftar = pelangganDAO.ambilSemuaPelanggan();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan :(");
            return;
        }
        for (Pelanggan p : daftar) {
            p.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Pelanggan yang ingin diupdate: ");
        Pelanggan p = pelangganDAO.cariById(idTarget);
        if (p == null) {
            Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
            return;
        }

        p.setNama(InputValidator.bacaTeks(scanner, "Nama Baru: "));
        p.setNoHp(InputValidator.bacaTeks(scanner, "No HP Baru: "));

        if (pelangganDAO.updatePelanggan(p)) {
            Pesan.tampilkanPesan("Data pelanggan berhasil diperbarui yah ^__^");
        }
    }

    public void hapusPelanggan() {
        System.out.println("=====================================");
        System.out.println("|          HAPUS PELANGGAN           |");
        System.out.println("=====================================");

        ArrayList<Pelanggan> daftar = pelangganDAO.ambilSemuaPelanggan();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan :(");
            return;
        }
        for (Pelanggan p : daftar) {
            p.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Pelanggan yang ingin dihapus: ");
        if (pelangganDAO.hapusPelanggan(idTarget)) {
            Pesan.tampilkanPesan("Data pelanggan berhasil dihapus yaa!!");
        }
    }

    // ===================== PAKET WEDDING =====================

    public void tambahPaket() {
        System.out.println("=====================================");
        System.out.println("|        TAMBAH PAKET WEDDING        |");
        System.out.println("=====================================");

        int id = InputValidator.bacaInt(scanner, "ID Paket: ");
        if (paketDAO.cariById(id) != null) {
            Pesan.tampilkanPesan("Yaahh.. ID Paket sudah dipakai :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Paket: ");
        PaketWedding paket = new PaketWedding(id, nama, 1);

        int harga;
        do {
            harga = InputValidator.bacaInt(scanner, "Harga: ");
            paket.setHarga(harga);
        } while (paket.getHarga() != harga);

        if (paketDAO.tambahPaket(paket)) {
            Pesan.tampilkanPesan("YAYY!! Paket wedding berhasil ditambahkan :D");
        }
    }

    public void tampilkanPaket() {
        System.out.println("=====================================");
        System.out.println("|        DAFTAR PAKET WEDDING        |");
        System.out.println("=====================================");

        ArrayList<PaketWedding> daftar = paketDAO.ambilSemuaPaket();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }
        for (PaketWedding pw : daftar) {
            pw.tampilkanInfo();
        }
    }

    public void updatePaket() {
        System.out.println("=====================================");
        System.out.println("|      UPDATE HARGA PAKET WEDDING    |");
        System.out.println("=====================================");

        ArrayList<PaketWedding> daftar = paketDAO.ambilSemuaPaket();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }
        for (PaketWedding pw : daftar) {
            pw.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Paket yang ingin diupdate: ");
        PaketWedding pw = paketDAO.cariById(idTarget);
        if (pw == null) {
            Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
            return;
        }

        int harga;
        do {
            harga = InputValidator.bacaInt(scanner, "Harga Baru: ");
            pw.setHarga(harga);
        } while (pw.getHarga() != harga);

        if (paketDAO.updateHarga(idTarget, harga)) {
            Pesan.tampilkanPesan("Harga paket wedding berhasil diperbarui yah ^__^");
        }
    }

    public void hapusPaket() {
        System.out.println("=====================================");
        System.out.println("|         HAPUS PAKET WEDDING        |");
        System.out.println("=====================================");

        ArrayList<PaketWedding> daftar = paketDAO.ambilSemuaPaket();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }
        for (PaketWedding pw : daftar) {
            pw.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Paket yang ingin dihapus: ");
        if (paketDAO.hapusPaket(idTarget)) {
            Pesan.tampilkanPesan("Paket wedding berhasil dihapus yaa!!");
        }
    }

    // ===================== PEMESANAN WEDDING =====================

    public void tambahPemesanan() {
        System.out.println("=====================================");
        System.out.println("|      TAMBAH PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        ArrayList<Pelanggan> daftarPelanggan = pelangganDAO.ambilSemuaPelanggan();
        if (daftarPelanggan == null) return;
        if (daftarPelanggan.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pelanggan, tambah dulu yuk :(");
            return;
        }

        ArrayList<PaketWedding> daftarPaket = paketDAO.ambilSemuaPaket();
        if (daftarPaket == null) return;
        if (daftarPaket.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data paket wedding :(");
            return;
        }

        int id = InputValidator.bacaInt(scanner, "ID Booking: ");
        if (pemesananWeddingDAO.cariById(id) != null) {
            Pesan.tampilkanPesan("Yaahh.. ID Booking sudah dipakai :(");
            return;
        }

        for (Pelanggan p : daftarPelanggan) {
            p.tampilkanInfo();
        }
        int idPelanggan = InputValidator.bacaInt(scanner, "Pilih ID Pelanggan: ");
        Pelanggan pelanggan = pelangganDAO.cariById(idPelanggan);
        if (pelanggan == null) {
            Pesan.tampilkanPesan("ID Pelanggan tidak ditemukan :(");
            return;
        }

        for (PaketWedding pw : daftarPaket) {
            pw.tampilkanInfo();
        }
        int idPaket = InputValidator.bacaInt(scanner, "Pilih ID Paket: ");
        PaketWedding paket = paketDAO.cariById(idPaket);
        if (paket == null) {
            Pesan.tampilkanPesan("ID Paket tidak ditemukan :(");
            return;
        }

        String venue = InputValidator.bacaTeks(scanner, "Venue: ");
        String tanggalAcara = InputValidator.bacaTanggal(scanner, "Tanggal Acara (dd-MM-yyyy): ");

        PemesananWedding pemesanan = new PemesananWedding(id, pelanggan, paket, venue, tanggalAcara, 1);

        int pax;
        do {
            pax = InputValidator.bacaInt(scanner, "Jumlah Pax: ");
            pemesanan.setPax(pax);
        } while (pemesanan.getPax() != pax);

        if (pemesananWeddingDAO.tambahPemesanan(pemesanan)) {
            Pesan.tampilkanPesan("Pemesanan wedding berhasil ditambahkan, happy wedding :D");
        }
    }

    public void tampilkanPemesanan() {
        System.out.println("=====================================");
        System.out.println("|      DAFTAR PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        ArrayList<PemesananWedding> daftar = pemesananWeddingDAO.ambilSemuaPemesanan();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
            return;
        }
        for (PemesananWedding pmw : daftar) {
            pmw.tampilkanInfo();
        }
    }

    public void updatePemesanan() {
        System.out.println("=====================================");
        System.out.println("|      UPDATE PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        ArrayList<PemesananWedding> daftar = pemesananWeddingDAO.ambilSemuaPemesanan();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
            return;
        }
        for (PemesananWedding p : daftar) {
            p.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Booking yang ingin diupdate: ");
        PemesananWedding pmw = pemesananWeddingDAO.cariById(idTarget);
        if (pmw == null) {
            Pesan.tampilkanPesan("ID Booking tidak ditemukan :(");
            return;
        }

        pmw.setVenue(InputValidator.bacaTeks(scanner, "Venue Baru: "));
        pmw.setTanggalAcara(InputValidator.bacaTanggal(scanner, "Tanggal Acara Baru (dd-MM-yyyy): "));

        int pax;
        do {
            pax = InputValidator.bacaInt(scanner, "Pax Baru: ");
            pmw.setPax(pax);
        } while (pmw.getPax() != pax);

        if (pemesananWeddingDAO.updatePemesanan(pmw)) {
            Pesan.tampilkanPesan("Pemesanan wedding berhasil diperbarui yah ^__^");
        }
    }

    public void hapusPemesanan() {
        System.out.println("=====================================");
        System.out.println("|       HAPUS PEMESANAN WEDDING      |");
        System.out.println("=====================================");

        ArrayList<PemesananWedding> daftar = pemesananWeddingDAO.ambilSemuaPemesanan();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
            return;
        }
        for (PemesananWedding p : daftar) {
            p.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Booking yang ingin dihapus: ");
        if (pemesananWeddingDAO.hapusPemesanan(idTarget)) {
            Pesan.tampilkanPesan("Pemesanan wedding berhasil dihapus yaa!!");
        }
    }

    // ===================== VENDOR =====================

    public void tambahVendor() {
        System.out.println("=====================================");
        System.out.println("|           TAMBAH VENDOR            |");
        System.out.println("=====================================");

        Menu.tampilkanMenuJenisVendor();
        int jenis = InputValidator.bacaPilihan(scanner, "Pilih (1-2): ", 1, 2);

        int id = InputValidator.bacaInt(scanner, "ID Vendor: ");
        if (vendorDAO.cariById(id) != null) {
            Pesan.tampilkanPesan("Yaahh.. ID Vendor sudah dipakai :(");
            return;
        }

        String nama = InputValidator.bacaTeks(scanner, "Nama Vendor: ");
        String noTelepon = InputValidator.bacaTeks(scanner, "No Telepon: ");

        if (jenis == 1) {
            String jenisMasakan = InputValidator.bacaTeks(scanner, "Jenis Masakan: ");
            String sistemPenyajian = InputValidator.bacaTeks(scanner, "Sistem Penyajian: ");

            VendorCatering vc = new VendorCatering(id, nama, noTelepon, jenisMasakan, sistemPenyajian, 1);

            int harga;
            do {
                harga = InputValidator.bacaInt(scanner, "Harga Per Pax: ");
                vc.setHargaPerPax(harga);
            } while (vc.getHargaPerPax() != harga);

            if (vendorDAO.tambahVendor(vc)) {
                Pesan.tampilkanPesan("YAYY!! Vendor catering berhasil ditambahkan :D");
            }
        } else {
            String temaDekorasi = InputValidator.bacaTeks(scanner, "Tema Dekorasi: ");
            String jenisDekorasi = InputValidator.bacaTeks(scanner, "Jenis Dekorasi: ");

            VendorDekorasi vd = new VendorDekorasi(id, nama, noTelepon, temaDekorasi, jenisDekorasi, 1);

            int harga;
            do {
                harga = InputValidator.bacaInt(scanner, "Harga Paket Dekorasi: ");
                vd.setHargaPaketDekorasi(harga);
            } while (vd.getHargaPaketDekorasi() != harga);

            if (vendorDAO.tambahVendor(vd)) {
                Pesan.tampilkanPesan("YAYY!! Vendor dekorasi berhasil ditambahkan :D");
            }
        }
    }

    public void tampilkanVendor() {
        System.out.println("=====================================");
        System.out.println("|           TAMPILKAN VENDOR         |");
        System.out.println("=====================================");

        Menu.tampilkanMenuTampilkanVendor();
        int pilihan = InputValidator.bacaPilihan(scanner, "Pilih (1-3): ", 1, 3);

        switch (pilihan) {
            case 1 -> tampilkanDaftarVendor(null);
            case 2 -> tampilkanDaftarVendor("Catering");
            case 3 -> tampilkanDaftarVendor("Dekorasi");
            default -> Pesan.tampilkanPesan("Pilihan tidak valid :(");
        }
    }

    private boolean tampilkanDaftarVendor(String jenis) {
        ArrayList<Vendor> daftar = vendorDAO.ambilSemuaVendor(jenis);
        if (daftar == null) return false;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data vendor" + (jenis == null ? "" : " " + jenis) + " :(");
            return false;
        }
        for (Vendor v : daftar) {
            v.tampilkanInfo();
        }
        return true;
    }

    public void updateVendor() {
        System.out.println("=====================================");
        System.out.println("|           UPDATE VENDOR            |");
        System.out.println("=====================================");

        if (!tampilkanDaftarVendor(null)) return;

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Vendor yang ingin diupdate: ");
        Vendor v = vendorDAO.cariById(idTarget);
        if (v == null) {
            Pesan.tampilkanPesan("ID Vendor tidak ditemukan :(");
            return;
        }

        int harga;
        do {
            harga = InputValidator.bacaInt(scanner, "Harga Baru: ");
            v.setHarga(harga);
        } while (v.getHarga() != harga);

        if (vendorDAO.updateHarga(v, harga)) {
            Pesan.tampilkanPesan("Harga vendor berhasil diperbarui yah ^__^");
        }
    }

    public void hapusVendor() {
        System.out.println("=====================================");
        System.out.println("|            HAPUS VENDOR            |");
        System.out.println("=====================================");

        if (!tampilkanDaftarVendor(null)) return;

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Vendor yang ingin dihapus: ");
        if (vendorDAO.hapusVendor(idTarget)) {
            Pesan.tampilkanPesan("Vendor berhasil dihapus yaa!!");
        }
    }

    // ===================== CETAK DOKUMEN =====================

    public void cetakInvoicePemesanan() {
        System.out.println("=====================================");
        System.out.println("|      CETAK INVOICE PEMESANAN      |");
        System.out.println("=====================================");

        ArrayList<PemesananWedding> daftar = pemesananWeddingDAO.ambilSemuaPemesanan();
        if (daftar == null) return;
        if (daftar.isEmpty()) {
            Pesan.tampilkanPesan("Yaaahh.. belum ada data pemesanan wedding :(");
            return;
        }
        for (PemesananWedding p : daftar) {
            p.tampilkanInfo();
        }

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Booking yang ingin dicetak: ");
        PemesananWedding pmw = pemesananWeddingDAO.cariById(idTarget);
        if (pmw == null) {
            Pesan.tampilkanPesan("ID Booking tidak ditemukan :(");
            return;
        }

        pmw.cetakDokumen();
        Pesan.tampilkanPesan("YAYY!! Invoice pemesanan berhasil dicetak :D");
    }

    public void cetakPembayaranVendor() {
        System.out.println("=====================================");
        System.out.println("|      CETAK PEMBAYARAN VENDOR      |");
        System.out.println("=====================================");

        if (!tampilkanDaftarVendor(null)) return;

        int idTarget = InputValidator.bacaInt(scanner, "Masukkan ID Vendor yang ingin dicetak: ");
        Vendor v = vendorDAO.cariById(idTarget);
        if (v == null) {
            Pesan.tampilkanPesan("ID Vendor tidak ditemukan :(");
            return;
        }

        if (v instanceof VendorCatering) {
            VendorCatering vc = (VendorCatering) v;

            int jumlahPax;
            do {
                jumlahPax = InputValidator.bacaInt(scanner, "Jumlah Pax: ");
                if (jumlahPax <= 0) {
                    Pesan.tampilkanPesan("Yaahh.. pax tidak boleh 0 atau kurang dari 0 dong :(");
                }
            } while (jumlahPax <= 0);

            vc.cetakDokumen(jumlahPax);
        } else {
            Cetakable dokumen = (Cetakable) v;
            dokumen.cetakDokumen();
        }

        Pesan.tampilkanPesan("YAYY!! Bukti pembayaran vendor berhasil dicetak :D");
    }
}