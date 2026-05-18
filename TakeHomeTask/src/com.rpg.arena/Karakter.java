package com.rpg.arena; // Menandakan file ini berada di dalam paket com.rpg.arena

public abstract class Karakter implements AksiBertarung {
    protected String nama; // Menyimpan nama dari karakter
    protected int hp; // Menyimpan total Health Points karakter
    protected int baseDamage; // Menyimpan kekuatan serangan dasar karakter
    protected boolean isDefending; // Menyimpan status apakah karakter sedang bertahan atau tidak

    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama; // Mengisi variabel nama kelas dengan parameter nama
        this.hp = hp; // Mengisi variabel hp kelas dengan parameter hp
        this.baseDamage = baseDamage; // Mengisi variabel baseDamage kelas dengan parameter baseDamage
        this.isDefending = false; // Mengatur status bertahan default ke false
    }

    // Metode untuk memproses pengurangan HP akibat serangan musuh
    public void terimaDamage(int damage) {
        // Mengecek apakah karakter sedang dalam posisi bersiaga/bertahan
        if (isDefending) {
            this.hp -= (damage / 2); // Jika true, damage yang masuk dipotong setengahnya
            this.isDefending = false; // Mengembalikan status bertahan menjadi false setelah menahan serangan
        } else {
            this.hp -= damage; // Jika false, damage mengurangi HP secara penuh tanpa potongan
        }

        // Memastikan agar nilai HP tidak menjadi minus di bawah angka nol
        if (this.hp < 0) {
            this.hp = 0; // Memaksa nilai HP tetap di angka nol jika terindikasi minus
        }
    }

    // Metode abstrak tanpa bodi yang wajib di-override oleh kelas konkret untuk cetak status
    public abstract void tampilkanStatus();

    // Getter untuk mengambil data nama
    public String getNama() {
        return nama; // Mengembalikan nilai dari variabel nama
    }

    // Setter untuk mengubah data nama jika diperlukan
    public void setNama(String nama) {
        this.nama = nama; // Memperbarui nilai nama
    }

    // Getter untuk memeriksa sisa HP karakter
    public int getHp() {
        return hp; // Mengembalikan nilai dari variabel hp
    }

    // Setter untuk mengubah jumlah HP secara manual
    public void setHp(int hp) {
        this.hp = hp; // Memperbarui nilai hp
    }

    // Getter untuk melihat kekuatan base damage
    public int getBaseDamage() {
        return baseDamage; // Mengembalikan nilai dari variabel baseDamage
    }

    // Setter untuk memperbarui daya serang dasar
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage; // Memperbarui nilai baseDamage
    }

    // Getter untuk memeriksa kondisi perlindungan aktif
    public boolean isDefending() {
        return isDefending; // Mengembalikan nilai kebenaran status isDefending
    }

    // Setter untuk memanipulasi status perlindungan karakter
    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending; // Memperbarui nilai status isDefending
    }
}
