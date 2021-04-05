package csui.advpro2021.tais.model;

public class LaporanPembayaran {
    public String month;
    public int jamKerja;
    public int pembayaran;

    public LaporanPembayaran(String month, int jamKerja, int pembayaran) {
        this.jamKerja = jamKerja;
        this.month = month;
        this.pembayaran = pembayaran;
    }


}
