public class Programmer extends Karyawan {
    private double gajiPokok;

    public Programmer(String nama, double gajiPokok) {
        super(nama);
        this.gajiPokok = gajiPokok;
    }

    public double hitungGaji() {
        return gajiPokok;
    }
}
