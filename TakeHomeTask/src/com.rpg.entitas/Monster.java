package com.rpg.entitas; // Menandakan file ini berada di dalam paket com.rpg.entitas

import com.rpg.arena.Karakter; // Mengimpor kelas induk Karakter dari paket seberang

// Membuat kelas Monster sebagai turunan dari Karakter
public class Monster extends Karakter {
    private String jenisMonster; // Menyimpan kategori atau tipe spesies monster

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster; // Mengisi spesifikasi jenis monster lokal
    }

    // Polymorphism Overriding untuk menentukan kekuatan serang monster
    @Override
    public int serang() {
        return this.baseDamage; // Monster hanya mengeluarkan daya serang murni dari base damage-nya saja
    }

    // Polymorphism Overriding untuk mekanisme bertahan unik monster (memulihkan HP)
    @Override
    public void bertahan() {
        this.hp += 15; // Monster memulihkan energinya sendiri sebesar 15 poin HP
        System.out.println("Monster " + this.nama + " (" + this.jenisMonster + ") bertahan dan memulihkan 15 HP!"); 
    }

    @Override
    public void gunakanItem() {
        System.out.println("Monster tidak tahu cara minum obat!");
    }

    // Polymorphism Overriding untuk menampilkan identitas dan sisa daya hidup monster
    @Override
    public void tampilkanStatus() {
        System.out.println("Nama Monster: " + this.nama + " [" + this.jenisMonster + "]");
        System.out.println("HP Monster: " + this.hp);
    }
}
