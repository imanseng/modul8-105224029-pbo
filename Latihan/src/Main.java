import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pembayaran> daftarTransaksi = new ArrayList<>();

        Pembayaran transaksiKK = new KartuKredit("Andi Wijaya", 500000, "4563-1234-8888-9999");
        Pembayaran transaksiEW = new EWallet("Siti Rahma", 150000, "081234567890");

        daftarTransaksi.add(transaksiKK);
        daftarTransaksi.add(transaksiEW);

        for (Pembayaran p : daftarTransaksi) {
            p.tampilkanDetail();
            
            if (p instanceof Keamanan) {
                Keamanan k = (Keamanan) p;
                boolean isAman = k.autentikasi();
                if (isAman) {
                    p.prosesPembayaran();
                }
            }
            
            System.out.println(); 
        }
    }
}
