package com.example.todoappodev.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoappodev.data.entity.Yapilacaklar
import com.example.todoappodev.databinding.CardTasarimBinding
import com.example.todoappodev.ui.fragment.AnasayfaFragmentDirections
import com.example.todoappodev.ui.viewmodel.AnasayfaViewModel
import com.example.todoappodev.utils.gecis
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context,
                          var yapilacaklarListesi:List<Yapilacaklar>,
                          var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int { // kaç tane tasarım gösterecek
        return yapilacaklarListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacaklar = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiAd.text = yapilacaklar.yapilacaklar_isim

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yapilacaklarDetayGecis(yapilacaklar = yapilacaklar) //veri transferi yapıyoruz
            Navigation.gecis(it, gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacaklar.yapilacaklar_isim} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(yapilacaklar.yapilacaklar_id)
                }.show()
        }
    }
}