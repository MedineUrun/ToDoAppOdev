package com.example.todoappodev.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoappodev.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var yrepo:YapilacaklarRepository) : ViewModel() {
    fun kaydet(yapilacaklar_isim:String){
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.kaydet(yapilacaklar_isim)
        }
    }
}