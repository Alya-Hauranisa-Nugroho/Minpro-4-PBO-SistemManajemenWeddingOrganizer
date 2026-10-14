package model;

public class PaketWedding {
    private final int idPaket;
    private final String namaPaket;
    private int harga;

    public PaketWedding(int idPaket, String namaPaket, int harga) {
        this.idPaket = idPaket;
        this.namaPaket = namaPaket;
        setHarga(harga);
    }

    public int getIdPaket() {
        return idPaket;
    }

    public String getNamaPaket() {
        return namaPaket;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        if (harga <= 0) {
            System.out.println("> [ Harga tidak boleh 0 atau kurang dari 0! ] <");
            return;
        }
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println("=====================================");
        System.out.println("ID Paket   : " + idPaket);
        System.out.println("Nama Paket : " + namaPaket);
        System.out.println("Harga      : Rp" + harga);
    }
    
    
}