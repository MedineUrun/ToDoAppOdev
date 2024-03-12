package com.example.todoappodev.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoappodev.R
import com.example.todoappodev.databinding.FragmentAnasayfaBinding
import com.example.todoappodev.ui.adapter.YapilacaklarAdapter
import com.example.todoappodev.ui.viewmodel.AnasayfaViewModel
import com.example.todoappodev.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val yapilacaklarAdapter = YapilacaklarAdapter(requireContext(), it, viewModel)
            binding.todoListRv.adapter = yapilacaklarAdapter
        }

        binding.todoListRv.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            Navigation.gecis(it, R.id.yapilacaklarKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }
}