package com.rpg.arena; // Menandakan file ini berada di dalam paket com.rpg.arena

// Membuat interface sebagai kontrak aksi yang bisa dilakukan saat bertarung
public interface AksiBertarung {
    int serang(); // Mengembalikan nilai damage yang dihasilkan saat menyerang
    void bertahan(); // Mengubah status karakter menjadi mode bertahan
    void gunakanItem(); // Melakukan aksi pemulihan atau penggunaan item
}
