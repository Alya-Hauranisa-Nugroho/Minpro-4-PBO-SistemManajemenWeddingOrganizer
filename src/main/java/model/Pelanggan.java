package model;

public class Pelanggan {
    private final int idPelanggan;
    private String nama;
    private String noHp;

    public Pelanggan(int idPelanggan, String nama, String noHp) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noHp = noHp;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void tampilkanInfo() {
        System.out.println("=====================================");
        System.out.println("ID Pelanggan : " + idPelanggan);
        System.out.println("Nama         : " + nama);
        System.out.println("No HP        : " + noHp);
    }
}