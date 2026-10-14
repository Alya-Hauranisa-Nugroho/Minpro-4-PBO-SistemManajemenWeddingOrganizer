package controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import model.dao.PemesananWeddingDAO;
import view.Pesan;

public class InputValidator {

    public static int bacaInt(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                Pesan.tampilkanPesan("Input harus angka yaa!!!");
            }
        }
    }

    public static int bacaPilihan(Scanner scanner, String label, int min, int max) {
        while (true) {
            int pilihan = bacaInt(scanner, label);

            if (pilihan >= min && pilihan <= max) {
                return pilihan;
            }

            Pesan.tampilkanPesan("Pilihannya cuma dari " + min + " sampai " + max + " yaa ^__^");
        }
    }

    public static String bacaTeks(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                Pesan.tampilkanPesan("Jangan dikosongin dong..");
            } else {
                return input;
            }
        }
    }

    public static String bacaTanggal(Scanner scanner, String label) {
        while (true) {
            String input = bacaTeks(scanner, label).trim();
            try {
                LocalDate.parse(input, PemesananWeddingDAO.FMT);
                return input;
            } catch (DateTimeParseException e) {
                Pesan.tampilkanPesan("Format tanggal harus dd-MM-yyyy dan tanggalnya harus valid yaa!!");
            }
        }
    }
}