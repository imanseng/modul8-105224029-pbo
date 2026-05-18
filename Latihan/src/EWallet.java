public class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Nomor HP E-Wallet: " + nomorHP);
        System.out.println("Biaya Admin     : Rp0 (Gratis)");
        System.out.println("Total Tagihan   : Rp" + nominal);
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi E-Wallet Berhasil.");
        return true;
    }
}
