package com.example.todoappodev.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoappodev.data.entity.Yapilacaklar

@Database(entities = [Yapilacaklar::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getYapilacaklarDao() : YapilacaklarDao
}
