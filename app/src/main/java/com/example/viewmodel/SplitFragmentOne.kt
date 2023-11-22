//package com.example.viewmodel
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import android.view.View
//import android.widget.Button
//import androidx.lifecycle.ViewModelProvider
//import com.example.viewmodel.R
//
//
//class SplitFragmentOne : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Membuat dan menginisialisasi tampilan fragmen
//        return inflater.inflate(
//            R.layout.fragment_split_one, container, false
//        )
//    }
//
//    override fun onViewCreated(
//        view: View,
//        savedInstanceState: Bundle?
//    ) {
//        super.onViewCreated(view, savedInstanceState)
//        // Mendapatkan elemen TextView dan menginisialisasi teksnya
//        val textView = view.findViewById<TextView>(R.id.fragment_split_one_text_view)
//        textView.text = getString(R.string.total, 0)
//
//        // Memanggil fungsi untuk mempersiapkan ViewModel
//        prepareViewModel()
//    }
//
//    private fun prepareViewModel() {
//        // Mendapatkan instance ViewModel dari activity yang berisi fragmen ini
//        val totalsViewModel = ViewModelProvider(requireActivity())
//            .get(TotalsViewModel::class.java)
//
//        // Memanggil fungsi untuk mengupdate teks dan menambahkan OnClickListener ke Button
//        updateText(totalsViewModel.total)
//        view?.findViewById<Button>(R.id.fragment_split_one_button)
//            ?.setOnClickListener {
//                // Ketika Button ditekan, memanggil fungsi untuk mengupdate teks dengan total yang diinkrement
//                updateText(totalsViewModel.increaseTotal())
//            }
//    }
//
//    private fun updateText(total: Int) {
//        // Mendapatkan elemen TextView dan mengupdate teksnya dengan total yang diberikan
//        val textView = view?.findViewById<TextView>(R.id.fragment_split_one_text_view)
//        textView?.text = getString(R.string.total, total)
//    }
//}

package com.example.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewmodel.R

class SplitFragmentOne : Fragment() {

    private var total = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create and initialize the fragment view
        return inflater.inflate(
            R.layout.fragment_split_one, container, false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Get the TextView element and initialize its text
        val textView = view.findViewById<TextView>(R.id.fragment_split_one_text_view)
        textView.text = getString(R.string.total, total)

        // Set an OnClickListener to the Button
        view.findViewById<Button>(R.id.fragment_split_one_button)
            .setOnClickListener {
                // When the Button is clicked, increment the total and update the TextView
                total++
                updateText(total)
            }
    }

    private fun updateText(total: Int) {
        // Get the TextView element and update its text with the provided total
        val textView = view?.findViewById<TextView>(R.id.fragment_split_one_text_view)
        textView?.text = getString(R.string.total, total)
    }
}

