package com.example.todoappodev.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoappodev.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {

    @Query("SELECT * FROM toDos")
    suspend fun yapilacaklariYukle() :  List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacaklar:Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacaklar:Yapilacaklar)

    @Delete
    suspend fun sil(yapilacaklar:Yapilacaklar)

    @Query("SELECT * FROM toDos WHERE yapilacaklar_isim like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) :  List<Yapilacaklar>
}