package com.rpg.entitas; // Menandakan file ini berada di dalam paket com.rpg.entitas

import com.rpg.arena.Karakter; // Mengimpor kelas induk Karakter dari paket seberang

// Membuat kelas Pahlawan sebagai turunan dari Karakter
public class Pahlawan extends Karakter {
    private int mana; // Menyimpan kapasitas energi sihir pahlawan
    private int level; // Menyimpan tingkat level kekuatan pahlawan

    // Constructor khusus pahlawan untuk merakit data awal hero
    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); // Memanggil constructor milik parent class (Karakter)
        this.mana = mana; // Menetapkan nilai mana awal pahlawan
        this.level = level; // Menetapkan tingkat level awal pahlawan
    }

    // Polymorphism Overriding untuk menyesuaikan mekanisme serang biasa pahlawan
    @Override
    public int serang() {
        return this.baseDamage * this.level; // Menghitung total damage berdasarkan damage dasar dikali level
    }

    // Method Overloading untuk membuat variasi metode serang kedua menggunakan skill & mana cost
    public int serang(String namaSkill, int manaCost) {
        // Validasi ketersediaan kapasitas mana pahlawan sebelum meluncurkan skill
        if (this.mana >= manaCost) {
            this.mana -= manaCost; // Mengurangi sisa mana pahlawan dengan ongkos skill yang dipakai
            System.out.println(this.nama + " mengeluarkan skill [" + namaSkill + "]!"); // Mengeluarkan teks nama skill
            return this.baseDamage * this.level * 2; // Mengembalikan output berupa damage kritikal sebesar 2x lipat
        } else {
            System.out.println("Mana tidak cukup untuk menggunakan " + namaSkill + "!"); // Pesan gagal akibat kehabisan mana
            return 0; // Mengembalikan damage nol karena aksi skill gagal diluncurkan
        }
    }

    // Polymorphism Overriding untuk enyesuaikan aksi bertahan milik pahlawan
    @Override
    public void bertahan() {
        this.isDefending = true; // Mengubah flag perlindungan menjadi true agar damage berikutnya terpangkas
        System.out.println(this.nama + " memasang posisi bertahan dan bersiaga!"); // Menampilkan status siaga hero
    }

    // Polymorphism Overriding untuk menyesuaikan fungsi pemulihan item untuk pahlawan
    @Override
    public void gunakanItem() {
        this.hp += 30; // Menambah poin nyawa pahlawan sebesar 30 poin sesuai perintah soal
        System.out.println(this.nama + " menggunakan Potion! HP bertambah 30."); // Menampilkan log penggunaan item pemulihan
    }

    // Polymorphism Overriding untuk menyesuaikan visualisasi status pahlawan ke layar
    @Override
    public void tampilkanStatus() {
        System.out.println("[ STATUS HERO: " + this.nama + " ]"); // Mencetak judul status hero
        System.out.println("HP: " + this.hp); // Menampilkan sisa poin nyawa hero saat ini
        System.out.println("Mana: " + this.mana); // Menampilkan sisa pasokan sihir hero saat ini
        System.out.println("Level: " + this.level); // Menampilkan peringkat level hero saat ini
    }

    // Getter enkapsulasi untuk mengambil sisa mana pahlawan
    public int getMana() {
        return mana; // Mengembalikan nilai mana pahlawan
    }

    // Getter enkapsulasi untuk mengambil nilai tingkat level pahlawan
    public int getLevel() {
        return level; // Mengembalikan tingkat tingkatan level pahlawan
    }
}
