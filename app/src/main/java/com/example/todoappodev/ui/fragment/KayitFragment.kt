package com.example.todoappodev.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoappodev.R
import com.example.todoappodev.databinding.FragmentKayitBinding
import com.example.todoappodev.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.btnKayit.setOnClickListener {
            val yapilacaklar_isim = binding.editTextYapilacaklarIsim.text.toString()
            viewModel.kaydet(yapilacaklar_isim)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitViewModel by viewModels()
        viewModel = tempViewModel
    }

}