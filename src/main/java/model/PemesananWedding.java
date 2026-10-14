package model;

public class PemesananWedding implements Cetakable {
    private final int idBooking;
    private final Pelanggan pelanggan;
    private final PaketWedding paketWedding;
    private String venue;
    private String tanggalAcara;
    private int pax;

    public PemesananWedding(int idBooking, Pelanggan pelanggan, PaketWedding paketWedding, String venue, String tanggalAcara, int pax) {
        this.idBooking = idBooking;
        this.pelanggan = pelanggan;
        this.paketWedding = paketWedding;
        this.venue = venue;
        this.tanggalAcara = tanggalAcara;
        setPax(pax);
    }

    public int getIdBooking() {
        return idBooking;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public PaketWedding getPaketWedding() {
        return paketWedding;
    }

    public String getVenue() {
        return venue;
    }

    public String getTanggalAcara() {
        return tanggalAcara;
    }

    public int getPax() {
        return pax;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setTanggalAcara(String tanggalAcara) {
        this.tanggalAcara = tanggalAcara;
    }

    public void setPax(int pax) {
        if (pax <= 0) {
            System.out.println("> [ Pax tidak boleh 0 atau kurang dari 0! ] <");
            return;
        }
        this.pax = pax;
    }

    public void tampilkanInfo() {
        System.out.println("=====================================");
        System.out.println("ID Booking    : " + idBooking);
        System.out.println("Pelanggan     : " + pelanggan.getNama());
        System.out.println("Paket         : " + paketWedding.getNamaPaket());
        System.out.println("Venue         : " + venue);
        System.out.println("Tanggal Acara : " + tanggalAcara);
        System.out.println("Pax           : " + pax);
    }
    
    public int hitungTotalPemesanan() {
        return paketWedding.getHarga();
    }
    
    @Override
    public void cetakDokumen() {
        System.out.println("==================================================");
        System.out.println("            INVOICE PEMESANAN WEDDING             ");
        System.out.println("==================================================");
        System.out.println("ID Booking    : " + idBooking);
        System.out.println("Pelanggan     : " + pelanggan.getNama());
        System.out.println("Paket Wedding : " + paketWedding.getNamaPaket());
        System.out.println("Tanggal Acara : " + tanggalAcara);
        System.out.println("Venue         : " + venue);
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL HARGA   : Rp" + hitungTotalPemesanan());
        System.out.println("==================================================");
    }
}