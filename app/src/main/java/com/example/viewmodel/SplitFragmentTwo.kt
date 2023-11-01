package com.example.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.R

class SplitFragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Membuat dan menginisialisasi tampilan fragmen dari file layout XML
        return inflater.inflate(
            R.layout.fragment_split_two, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan instance dari ViewModel "TotalsViewModel" dari activity yang berisi fragmen ini
        val totalsViewModel = ViewModelProvider(requireActivity())
            .get(TotalsViewModel::class.java)

        // Memanggil fungsi "updateText" untuk mengupdate teks pada TextView dengan total yang diberikan
        updateText(totalsViewModel.total)
    }

    private fun updateText(total: Int) {
        // Mengambil elemen TextView dengan ID "fragment_split_two_text_view" dari tampilan
        // dan mengupdate teksnya dengan total yang diberikan dalam format yang didefinisikan dalam sumber daya string
        view?.findViewById<TextView>(R.id.fragment_split_two_text_view)?.text =
            getString(R.string.total, total)
    }
}