package com.example.todoappodev.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoappodev.R
import com.example.todoappodev.databinding.FragmentDetayBinding
import com.example.todoappodev.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel:DetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle: DetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacaklar

        binding.editTextYapilacaklar.setText(gelenYapilacak.yapilacaklar_isim)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacaklar_isim = binding.editTextYapilacaklar.text.toString()
            viewModel.guncelle(gelenYapilacak.yapilacaklar_id, yapilacaklar_isim)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}