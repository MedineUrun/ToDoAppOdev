package com.example.todoappodev.data.datasource

import com.example.todoappodev.data.entity.Yapilacaklar
import com.example.todoappodev.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var ydao:YapilacaklarDao) {
    suspend fun kaydet(yapilacaklar_isim:String){
        val yeniYapilacak = Yapilacaklar(0,yapilacaklar_isim)
        ydao.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(yapilacaklar_id:Int, yapilacaklar_isim:String){
        val guncellenenYapilacak = Yapilacaklar(yapilacaklar_id,yapilacaklar_isim)
        ydao.guncelle(guncellenenYapilacak)
    }

    suspend fun sil(yapilacaklar_id: Int){
        val silinenYapilacak = Yapilacaklar(yapilacaklar_id, "")
        ydao.sil(silinenYapilacak)
    }

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.yapilacaklariYukle()
        }

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.ara(aramaKelimesi)
        }
}



