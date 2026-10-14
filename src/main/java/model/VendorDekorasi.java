package model;

public class VendorDekorasi extends Vendor implements Cetakable {

    private final String temaDekorasi;
    private final String jenisDekorasi;
    private int hargaPaketDekorasi;

    public VendorDekorasi(int idVendor, String namaVendor, String noTelepon, String temaDekorasi,
                           String jenisDekorasi, int hargaPaketDekorasi) {
        super(idVendor, namaVendor, noTelepon);
        this.temaDekorasi = temaDekorasi;
        this.jenisDekorasi = jenisDekorasi;
        setHargaPaketDekorasi(hargaPaketDekorasi);
    }

    public String getTemaDekorasi() {
        return temaDekorasi;
    }

    public String getJenisDekorasi() {
        return jenisDekorasi;
    }

    public int getHargaPaketDekorasi() {
        return hargaPaketDekorasi;
    }

    public void setHargaPaketDekorasi(int hargaPaketDekorasi) {
        if (hargaPaketDekorasi <= 0) {
            System.out.println("> [ Harga paket dekorasi tidak boleh 0 atau kurang dari 0! ] <");
            return;
        }
        this.hargaPaketDekorasi = hargaPaketDekorasi;
    }

    @Override
    public String getJenisVendor() {
        return "Dekorasi";
    }

    @Override
    public int getHarga() {
        return hargaPaketDekorasi;
    }

    @Override
    public void setHarga(int harga) {
        setHargaPaketDekorasi(harga);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Vendor        : Dekorasi");
        System.out.println("Tema Dekorasi       : " + temaDekorasi);
        System.out.println("Jenis Dekorasi      : " + jenisDekorasi);
        System.out.println("Harga Paket Dekorasi: Rp" + hargaPaketDekorasi);
    }
    
    @Override
    public void cetakDokumen() {
        System.out.println("==================================================");
        System.out.println("          BUKTI PEMBAYARAN VENDOR DEKORASI        ");
        System.out.println("==================================================");
        System.out.println("ID Vendor           : " + getIdVendor());
        System.out.println("Nama Vendor         : " + getNamaVendor());
        System.out.println("Tema Dekorasi       : " + temaDekorasi);
        System.out.println("Jenis Dekorasi      : " + jenisDekorasi);
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL DIBAYARKAN    : Rp" + getHargaPaketDekorasi());
        System.out.println("==================================================");
    }
}