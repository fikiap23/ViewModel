package com.example.viewmodel

import androidx.lifecycle.ViewModel

class TotalsViewModel : ViewModel() {
    // Variabel untuk menyimpan total
    var total = 0

    // Fungsi untuk meningkatkan total dan mengembalikan total yang ditingkatkan
    fun increaseTotal(): Int {
        total++ // Menambahkan 1 ke total
        return total // Mengembalikan total yang baru
    }
}
