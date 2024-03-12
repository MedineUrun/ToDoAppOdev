package com.example.todoappodev.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "toDos")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "yapilacaklar_id") @NotNull var yapilacaklar_id:Int,
                        @ColumnInfo(name = "yapilacaklar_isim") @NotNull var yapilacaklar_isim:String) :Serializable {
}
