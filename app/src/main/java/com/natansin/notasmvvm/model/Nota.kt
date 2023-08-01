package com.natansin.notasmvvm.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notas")
@Parcelize
data class Nota (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val notaTitulo: String,
    val notaCorpo: String
        ): Parcelable