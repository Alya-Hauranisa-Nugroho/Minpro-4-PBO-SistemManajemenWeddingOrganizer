package main;

import java.util.Scanner;

import controller.WeddingCRUD;
import controller.InputValidator;
import view.Menu;
import view.Pesan;

public class WeddingOrganizer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WeddingCRUD weddingCRUD = new WeddingCRUD(scanner);

        boolean berjalan = true;

        while (berjalan) {
            Menu.tampilkanMenuUtama();
            int pilihan = InputValidator.bacaPilihan(scanner, "Pilih menu (1-6): ", 1, 6);

            switch (pilihan) {
                case 1 -> {
                    boolean berjalanTambah = true;
                    while (berjalanTambah) {
                        Menu.tampilkanMenuTambah();
                        int pilihanTambah = InputValidator.bacaPilihan(scanner, "Pilih menu (1-5): ", 1, 5);

                        switch (pilihanTambah) {
                            case 1 -> weddingCRUD.tambahPelanggan();
                            case 2 -> weddingCRUD.tambahPaket();
                            case 3 -> weddingCRUD.tambahPemesanan();
                            case 4 -> weddingCRUD.tambahVendor();
                            case 5 -> {
                                berjalanTambah = false;
                                Pesan.tampilkanPesan("Kembali ke menu utama yah :D");
                            }
                            default -> Pesan.tampilkanPesan("Pilihan kamu tidak valid ^__^");
                        }
                    }
                }
                case 2 -> {
                    boolean berjalanTampilkan = true;
                    while (berjalanTampilkan) {
                        Menu.tampilkanMenuTampilkan();
                        int pilihanTampilkan = InputValidator.bacaPilihan(scanner, "Pilih menu (1-5): ", 1, 5);

                        switch (pilihanTampilkan) {
                            case 1 -> weddingCRUD.tampilkanPelanggan();
                            case 2 -> weddingCRUD.tampilkanPaket();
                            case 3 -> weddingCRUD.tampilkanPemesanan();
                            case 4 -> weddingCRUD.tampilkanVendor();
                            case 5 -> {
                                berjalanTampilkan = false;
                                Pesan.tampilkanPesan("Kembali ke menu utama yah :D");
                            }
                            default -> Pesan.tampilkanPesan("Pilihan kamu tidak valid ^__^");
                        }
                    }
                }
                case 3 -> {
                    boolean berjalanUpdate = true;
                    while (berjalanUpdate) {
                        Menu.tampilkanMenuUpdate();
                        int pilihanUpdate = InputValidator.bacaPilihan(scanner, "Pilih menu (1-5): ", 1, 5);

                        switch (pilihanUpdate) {
                            case 1 -> weddingCRUD.updatePelanggan();
                            case 2 -> weddingCRUD.updatePaket();
                            case 3 -> weddingCRUD.updatePemesanan();
                            case 4 -> weddingCRUD.updateVendor();
                            case 5 -> {
                                berjalanUpdate = false;
                                Pesan.tampilkanPesan("Kembali ke menu utama yah :D");
                            }
                            default -> Pesan.tampilkanPesan("Pilihan kamu tidak valid ^__^");
                        }
                    }
                }
                case 4 -> {
                    boolean berjalanHapus = true;
                    while (berjalanHapus) {
                        Menu.tampilkanMenuHapus();
                        int pilihanHapus = InputValidator.bacaPilihan(scanner, "Pilih menu (1-5): ", 1, 5);

                        switch (pilihanHapus) {
                            case 1 -> weddingCRUD.hapusPelanggan();
                            case 2 -> weddingCRUD.hapusPaket();
                            case 3 -> weddingCRUD.hapusPemesanan();
                            case 4 -> weddingCRUD.hapusVendor();
                            case 5 -> {
                                berjalanHapus = false;
                                Pesan.tampilkanPesan("Kembali ke menu utama yah :D");
                            }
                            default -> Pesan.tampilkanPesan("Pilihan kamu tidak valid ^__^");
                        }
                    }
                }
                case 5 -> {
                    boolean berjalanCetak = true;
                    while (berjalanCetak) {
                        Menu.tampilkanMenuCetakDokumen();
                        int pilihanCetak = InputValidator.bacaPilihan(scanner, "Pilih menu (1-3): ", 1, 3);

                        switch (pilihanCetak) {
                            case 1 -> weddingCRUD.cetakInvoicePemesanan();
                            case 2 -> weddingCRUD.cetakPembayaranVendor();
                            case 3 -> {
                                berjalanCetak = false;
                                Pesan.tampilkanPesan("Kembali ke menu utama yah :D");
                            }
                            default -> Pesan.tampilkanPesan("Pilihan kamu tidak valid ^__^");
                        }
                    }
                }
                case 6 -> berjalan = false;
                default -> Pesan.tampilkanPesan("Pilihan kamu tidak valid ^__^");
            }
        }
        scanner.close();
        System.out.println("> [ BYEEEE!! ] <");
    }
}