package com.rpg.main; // Menandakan file ini berada di dalam paket com.rpg.main

import com.rpg.entitas.Pahlawan; // Mengimpor kelas cetakan Pahlawan dari paket entitas
import com.rpg.entitas.Monster; // Mengimpor kelas cetakan Monster dari paket entitas
import java.util.Scanner; // Mengaktifkan modul bawaan Java untuk menangkap ketikan user di console

// Kelas utama yang bertindak sebagai mesin penggerak alur simulasi game RPG
public class GameEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Instansiasi objek Scanner untuk mengelola perintah input data

        System.out.print("Masukkan nama Pahlawan Anda: "); // Meminta user menuliskan nama
        String namaInput = input.nextLine(); // Membaca strings nama yang diketik oleh user

        // Menciptakan satu objek pahlawan tangguh dengan spesifikasi stat yang ditentukan
        Pahlawan hero = new Pahlawan(namaInput, 150, 15, 50, 1);

        // Menerapkan array polymorphism untuk menampung barisan 3 monster penjaga dungeon secara berurutan
        Monster[] daftarMonster = new Monster[3]; // Menyiapkan slot memori array sepanjang 3 baris
        daftarMonster[0] = new Monster("Slime Hijau", 40, 8, "Normal"); // Mengisi slot pertama dengan Slime kecil
        daftarMonster[1] = new Monster("Goblin Penyamun", 60, 12, "Elite"); // Mengisi slot kedua dengan Goblin petarung
        daftarMonster[2] = new Monster("Raja Naga Api", 100, 20, "Boss"); // Mengisi tantangan terakhir dengan naga raksasa

        // Perulangan FOR untuk menggilir satu per satu monster dari dalam Array
        for (int i = 0; i < daftarMonster.length; i++) {
            Monster monsterSaatIni = daftarMonster[i]; // Memindahkan objek monster indeks aktif ke variabel penampung sementara

            // Validasi darurat untuk menghentikan seluruh giliran for jika pahlawan terlanjur mati duluan
            if (hero.getHp() <= 0) {
                break; // Memaksa keluar dari perulangan for luar karena jagoan utama telah gugur
            }

            System.out.println("PERINGATAN! " + monsterSaatIni.getNama() + " menghadang jalanmu!");

            // Perulangan WHILE internal (Battle Loop) yang mengunci pertarungan sampai salah satu mati
            while (hero.getHp() > 0 && monsterSaatIni.getHp() > 0) {
                hero.tampilkanStatus(); // Ringkasan statistik kesehatan pahlawan saat ini
                monsterSaatIni.tampilkanStatus(); // Ringkasan statistik kesehatan monster target saat ini
                
                System.out.println("\n[] GILIRAN ANDA ]"); // Penanda giliran aksi player
                System.out.println("1. Serang Biasa"); // Opsi taktik serang dasar tanpa biaya mana
                System.out.println("2. Gunakan Skill (Cost: 20 Mana)"); // Opsi serangan magis berdaya hancur tinggi
                System.out.println("3. Bertahan / Heal (+30 HP)"); // Opsi defensive untuk memulihkan nyawa dan proteksi tameng
                System.out.print("Pilih aksi (1-3): ");
                int pilihan = input.nextInt(); // Mengunci masukan pilihan angka integer dari user

                int damageKeMonster = 0; // Menginisiasi wadah penampung kalkulasi poin serangan dari pahlawan

                // Mengolah percabangan switch-case atas menu taktik pertarungan yang dipilih player
                switch (pilihan) {
                    case 1: // Kondisi jika player memantapkan pilihan pada Serang Biasa
                        damageKeMonster = hero.serang(); // Memanggil kalkulasi damage serang biasa pahlawan
                        System.out.println("\n" + hero.getNama() + " menebas keras " + monsterSaatIni.getNama() + " sebesar " + damageKeMonster + " damage!");
                        monsterSaatIni.terimaDamage(damageKeMonster); // Memasukkan kalkulasi kerusakan ke sistem tubuh monster
                        break; // Keluar dari struktur switch-case menuju baris instruksi berikutnya
                    case 2: // Kondisi jika player mengaktifkan sihir jurus mematikan
                        damageKeMonster = hero.serang("Sabetan Pamungkas", 20); // Memicu overloading metode serang skill dengan beban 20 mana cost
                        if (damageKeMonster > 0) { // Melakukan pemeriksaan apakah peluncuran sihir divalidasi sukses atau gagal
                            System.out.println(monsterSaatIni.getNama() + " terkena ledakan sihir sebesar " + damageKeMonster + " damage!");
                            monsterSaatIni.terimaDamage(damageKeMonster); // Melukai organ vital monster berdasarkan hasil kalkulasi ledakan skill
                        }
                        break; // Keluar dari struktur switch-case menuju baris instruksi berikutnya
                    case 3: // Kondisi jika player memilih mempertebal ketahanan barisan pertahanannya
                        hero.bertahan(); // Memasang mode perlindungan isDefending menjadi aktif lewat method induk
                        hero.gunakanItem(); // Sekaligus menyuntikkan ramuan potion penambah nyawa 30 poin ke tubuh pahlawan
                        break; // Keluar dari struktur switch-case menuju baris instruksi berikutnya
                    default:
                        System.out.println("\nAksi tidak valid! Anda membuang kesempatan giliran berharga!");
                        break; // Keluar dari struktur switch-case menuju baris instruksi berikutnya
                }

                // Giliran serangan balasan dari monster dijalankan secara otomatis jika dia terdeteksi masih bernyawa
                if (monsterSaatIni.getHp() > 0) {
                    // Penjaga gerak acak kecerdasan monster tiruan (jika sisa HP kritis dibawah 25, dia condong bertahan)
                    if (monsterSaatIni.getHp() < 25 && Math.random() < 0.5) {
                        monsterSaatIni.bertahan(); // Monster membelokkan aksinya untuk memicu mekanisme regenerasi nyawa internal
                    } else {
                        int damageKeHero = monsterSaatIni.serang(); // Mengambil kalkulasi kekuatan gigitan amarah monster
                        System.out.println("Monster " + monsterSaatIni.getNama() + " mencakar balik " + hero.getNama() + " sebesar " + damageKeHero + " damage!"); 
                        hero.terimaDamage(damageKeHero); // Pahlawan menderita luka goresan sesuai damage musuh masuk
                    }
                } else {
                    System.out.println("\nSelamat! " + monsterSaatIni.getNama() + " telah mati terkapar!");
            } 
        } 
    }
        // Menguji status akhir kelangsungan hidup jagoan utama menggunakan struktur seleksi if-else
        if (hero.getHp() > 0) {
            System.out.println("CONGRATULATIONS! " + hero.getNama() + " Berhasil Menamatkan Dungeon & Selamat!");
        } else {
            System.out.println("GAME OVER... Pahlawan " + hero.getNama() + " gugur bersimbah darah di dalam dungeon."); 
        }

        input.close();
    } 
} 
