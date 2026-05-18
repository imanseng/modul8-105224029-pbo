public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    public double hitungOngkosKirim() {
        double ongkosDasar = (beratBarang * 5000) + (jarakTempuh * 2000);
        if (jenisTruk.equalsIgnoreCase("Tronton")) {
            ongkosDasar += 150000;
        }
        return ongkosDasar;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return this.statusSaatIni;
    }
}
