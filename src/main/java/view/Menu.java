package view;

public class Menu {

    public static void tampilkanMenuUtama() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("|            Houry do Wedds         |");
        System.out.println("|          WEDDING ORGANIZER        |");
        System.out.println("=====================================");
        System.out.println("|              MENU UTAMA           |");
        System.out.println("=====================================");
        System.out.println("1. Menu Tambah");
        System.out.println("2. Menu Tampilkan");
        System.out.println("3. Menu Update");
        System.out.println("4. Menu Hapus");
        System.out.println("5. Menu Cetak Dokumen");
        System.out.println("6. Keluar >>>");
    }

    public static void tampilkanMenuTambah() {
        System.out.println("\n=====================================");
        System.out.println("|            MENU TAMBAH            |");
        System.out.println("=====================================");
        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Tambah Paket Wedding");
        System.out.println("3. Tambah Pemesanan Wedding");
        System.out.println("4. Tambah Vendor");
        System.out.println("5. Kembali ke Menu Utama");
    }

    public static void tampilkanMenuTampilkan() {
        System.out.println("\n=====================================");
        System.out.println("|          MENU TAMPILKAN           |");
        System.out.println("=====================================");
        System.out.println("1. Tampilkan Pelanggan");
        System.out.println("2. Tampilkan Paket Wedding");
        System.out.println("3. Tampilkan Pemesanan Wedding");
        System.out.println("4. Tampilkan Vendor");
        System.out.println("5. Kembali ke Menu Utama");
    }

    public static void tampilkanMenuUpdate() {
        System.out.println("\n=====================================");
        System.out.println("|            MENU UPDATE            |");
        System.out.println("=====================================");
        System.out.println("1. Update Pelanggan");
        System.out.println("2. Update Paket Wedding");
        System.out.println("3. Update Pemesanan Wedding");
        System.out.println("4. Update Vendor");
        System.out.println("5. Kembali ke Menu Utama");
    }

    public static void tampilkanMenuHapus() {
        System.out.println("\n=====================================");
        System.out.println("|            MENU HAPUS             |");
        System.out.println("=====================================");
        System.out.println("1. Hapus Pelanggan");
        System.out.println("2. Hapus Paket Wedding");
        System.out.println("3. Hapus Pemesanan Wedding");
        System.out.println("4. Hapus Vendor");
        System.out.println("5. Kembali ke Menu Utama");
    }
    
    public static void tampilkanMenuCetakDokumen() {
        System.out.println("\n=====================================");
        System.out.println("|        MENU CETAK DOKUMEN         |");
        System.out.println("=====================================");
        System.out.println("1. Cetak Invoice Pemesanan Wedding");
        System.out.println("2. Cetak Pembayaran Vendor");
        System.out.println("3. Kembali ke Menu Utama");
    }

    public static void tampilkanMenuJenisVendor() {
        System.out.println("Pilih dulu yaa.. mau vendor apa??");
        System.out.println("1. Vendor Catering");
        System.out.println("2. Vendor Dekorasi");
    }

    public static void tampilkanMenuTampilkanVendor() {
        System.out.println("Mau liat yang mana nihh??");
        System.out.println("1. Tampilkan Semua Vendor");
        System.out.println("2. Tampilkan Vendor Catering");
        System.out.println("3. Tampilkan Vendor Dekorasi");
    }
}