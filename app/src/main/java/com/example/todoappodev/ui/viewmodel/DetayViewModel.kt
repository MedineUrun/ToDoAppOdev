package com.example.todoappodev.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoappodev.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var yrepo:YapilacaklarRepository) : ViewModel() {

    fun guncelle(yapilacaklar_id:Int, yapilacaklar_isim:String){
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.guncelle(yapilacaklar_id,yapilacaklar_isim)
        }
    }
}