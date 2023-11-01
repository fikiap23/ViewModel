## Penjelasan ViewModel

`ViewModel` adalah komponen arsitektur Android yang digunakan untuk mengelola dan mempertahankan data yang terkait dengan UI dalam siklus hidup aplikasi Android. Dalam aplikasi Android, `ViewModel` berfungsi untuk memisahkan logika bisnis dari komponen UI, seperti aktivitas dan fragmen, sehingga memungkinkan pengembangan aplikasi yang lebih terorganisir, efisien, dan mudah diuji.

### Kegunaan Utama ViewModel

1. **Pemisahan Logika Bisnis dari UI**: `ViewModel` memungkinkan pemisahan yang jelas antara logika bisnis aplikasi dan tampilan UI. Ini membantu menjaga kode bersih dan mudah dipahami.

2. **Pemertahanan Data**: Salah satu fitur utama dari `ViewModel` adalah kemampuannya untuk mempertahankan data selama perubahan konfigurasi, seperti rotasi layar, tanpa kehilangan data. Hal ini menghindari kebutuhan untuk melakukan permintaan data ulang dan meningkatkan efisiensi aplikasi.

3. **Berbagi Data**: `ViewModel` dapat digunakan untuk berbagi data antara berbagai komponen UI dalam satu aktivitas. Ini sangat bermanfaat dalam situasi di mana beberapa fragmen perlu berkomunikasi satu sama lain.

4. **Menghindari Kehilangan Data**: Dengan menggunakan `ViewModel`, aplikasi dapat menghindari kehilangan data ketika komponen UI dihancurkan dan kemudian dibuat kembali, seperti saat perangkat diputar (rotasi layar).

5. **Peningkatan Kinerja**: Dengan `ViewModel`, Kami dapat mempertahankan data yang diambil dari sumber daya yang mahal (seperti jaringan atau database) di memori dan menghindari pengambilan ulang data yang mahal. Hal ini meningkatkan kinerja dan efisiensi aplikasi.

### Implementasi `ViewModel` dalam Kode

```kotlin
class TotalsViewModel : ViewModel() {
    // Variabel untuk menyimpan total
    var total = 0

    // Fungsi untuk meningkatkan total dan mengembalikan total yang ditingkatkan
    fun increaseTotal(): Int {
        total++ // Menambahkan 1 ke total
        return total // Mengembalikan total yang baru
    }
}

```

Dalam kode program yang telah Kami berikan, Kami menggunakan kelas `TotalsViewModel` sebagai contoh implementasi `ViewModel`. `TotalsViewModel` memiliki dua fitur utama:

- Variabel `total`: Digunakan untuk menyimpan total yang akan ditampilkan dalam tampilan.

- Fungsi `increaseTotal()`: Digunakan untuk meningkatkan total dan mengembalikan total yang ditingkatkan. Fungsi ini adalah contoh operasi yang berhubungan dengan logika bisnis yang dapat dikelola oleh `ViewModel`.

`TotalsViewModel` digunakan oleh fragmen Kami untuk mengelola data total dan berinteraksi dengan data ini tanpa perlu khawatir tentang perubahan siklus hidup komponen UI. Dengan ini, kode terkait dengan data total dan logika bisnis terisolasi dalam `ViewModel`, yang mempermudah pemeliharaan dan pengembangan aplikasi Kami.

Contoh Fragment yang mengakses viewModel yaitu SplitFragmentOne

```kotlin
class SplitFragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Membuat dan menginisialisasi tampilan fragmen
        return inflater.inflate(
            R.layout.fragment_split_one, container, false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        // Mendapatkan elemen TextView dan menginisialisasi teksnya
        val textView = view.findViewById<TextView>(R.id.fragment_split_one_text_view)
        textView.text = getString(R.string.total, 0)

        // Memanggil fungsi untuk mempersiapkan ViewModel
        prepareViewModel()
    }

    private fun prepareViewModel() {
        // Mendapatkan instance ViewModel dari activity yang berisi fragmen ini
        val totalsViewModel = ViewModelProvider(requireActivity())
            .get(TotalsViewModel::class.java)

        // Memanggil fungsi untuk mengupdate teks dan menambahkan OnClickListener ke Button
        updateText(totalsViewModel.total)
        view?.findViewById<Button>(R.id.fragment_split_one_button)
            ?.setOnClickListener {
                // Ketika Button ditekan, memanggil fungsi untuk mengupdate teks dengan total yang diinkrement
                updateText(totalsViewModel.increaseTotal())
            }
    }

    private fun updateText(total: Int) {
        // Mendapatkan elemen TextView dan mengupdate teksnya dengan total yang diberikan
        val textView = view?.findViewById<TextView>(R.id.fragment_split_one_text_view)
        textView?.text = getString(R.string.total, total)
    }
}

```

Secara singkat, dalam kode tersebut:

- `TotalsViewModel` digunakan untuk menyimpan total dan fungsi untuk meningkatkannya.

- `SplitFragmentOne` menggunakan `TotalsViewModel` untuk mengakses total dan mengupdate tampilan ketika tombol ditekan.

- `ViewModel` memisahkan logika bisnis dari komponen UI dan mempertahankan data selama perubahan konfigurasi, seperti rotasi layar.
