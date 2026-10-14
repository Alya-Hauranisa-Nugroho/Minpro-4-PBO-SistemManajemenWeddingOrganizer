package model;

public class VendorCatering extends Vendor implements Cetakable {

    private final String jenisMasakan;
    private final String sistemPenyajian;
    private int hargaPerPax;

    public VendorCatering(int idVendor, String namaVendor, String noTelepon, String jenisMasakan, String sistemPenyajian, int hargaPerPax) {
        super(idVendor, namaVendor, noTelepon);
        this.jenisMasakan = jenisMasakan;
        this.sistemPenyajian = sistemPenyajian;
        setHargaPerPax(hargaPerPax);
    }

    public String getJenisMasakan() {
        return jenisMasakan;
    }

    public String getSistemPenyajian() {
        return sistemPenyajian;
    }

    public int getHargaPerPax() {
        return hargaPerPax;
    }

    public void setHargaPerPax(int hargaPerPax) {
        if (hargaPerPax <= 0) {
            System.out.println("> [ Harga per pax tidak boleh 0 atau kurang dari 0! ] <");
            return;
        }
        this.hargaPerPax = hargaPerPax;
    }

    @Override
    public String getJenisVendor() {
        return "Catering";
    }

    @Override
    public int getHarga() {
        return hargaPerPax;
    }

    @Override
    public void setHarga(int harga) {
        setHargaPerPax(harga);
    }
  
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Vendor     : Catering");
        System.out.println("Jenis Masakan    : " + jenisMasakan);
        System.out.println("Sistem Penyajian : " + sistemPenyajian);
        System.out.println("Harga Per Pax    : Rp" + hargaPerPax);
    }
    
    
    @Override
    public void cetakDokumen() {
        cetakDokumen(1); 
    }

    public void cetakDokumen(int jumlahPax) {
        int totalBayar = getHargaPerPax() * jumlahPax;
        System.out.println("==================================================");
        System.out.println("           BUKTI PEMBAYARAN VENDOR CATERING       ");
        System.out.println("==================================================");
        System.out.println("ID Vendor        : " + getIdVendor());
        System.out.println("Nama Vendor      : " + getNamaVendor());
        System.out.println("Jenis Masakan    : " + jenisMasakan);
        System.out.println("Sistem Penyajian : " + sistemPenyajian);
        System.out.println("Harga / Pax      : Rp" + hargaPerPax);
        System.out.println("Jumlah Pax       : " + jumlahPax);
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL DIBAYARKAN : Rp" + totalBayar);
        System.out.println("==================================================");
    }
}