public class Main {
    public static void main(String[] args) {
        PengirimanDarat darat = new PengirimanDarat("DARAT", 50, 100, "Tronton");
        PengirimanUdara udara = new PengirimanUdara("UDARA", 10, 800, "123", 5000000);

        darat.updateStatus("Sedang di jalan tol bandara Soekarno-Hatta");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        LayananPengiriman[] daftarKargo = { darat, udara };

        for (LayananPengiriman kargo : daftarKargo) {
            kargo.cetakResi();
            
            if (kargo instanceof LacakKargo) {
                LacakKargo pelacak = (LacakKargo) kargo;
                System.out.println("Status/Lokasi: " + pelacak.cekLokasiTerakhir());
            }

            double ongkosDasar = kargo.hitungOngkosKirim();
            double totalTagihan = ongkosDasar;

            System.out.println("Ongkos Kirim: Rp " + ongkosDasar);

            if (kargo instanceof Asuransi) {
                Asuransi proteksi = (Asuransi) kargo;
                
                proteksi.cetakPolis();
                
                double nilaiBarang = ((PengirimanUdara) kargo).getNilaiBarang();
                double biayaPremi = proteksi.hitungPremi(nilaiBarang);
                
                System.out.println("Nilai Barang: Rp " + nilaiBarang);
                System.out.println("Biaya Premi (3%): Rp " + biayaPremi);
                
                totalTagihan += biayaPremi;
            }

            System.out.println("TOTAL TAGIHAN: Rp " + totalTagihan);
        }
    }
}
