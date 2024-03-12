package com.example.todoappodev.data.repo

import com.example.todoappodev.data.datasource.YapilacaklarDataSource
import com.example.todoappodev.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds:YapilacaklarDataSource) {

    suspend fun kaydet(yapiacaklar_isim:String) = yds.kaydet(yapiacaklar_isim)

    suspend fun guncelle(yapilacaklar_id:Int, yapiacaklar_isim:String) = yds.guncelle(yapilacaklar_id, yapiacaklar_isim)

    suspend fun sil(yapilacaklar_id:Int) = yds.sil(yapilacaklar_id)

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> = yds.yapilacaklariYukle()

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> = yds.ara(aramaKelimesi)

}
