package com.natansin.notasmvvm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.natansin.notasmvvm.model.Nota

@Dao
interface NotaDao {
    // substitui caso ja exista uma nota
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNota(nota: Nota)

    @Update
    suspend fun atualizaNota(nota: Nota)


    @Delete
    suspend fun apagaNota(nota: Nota)



    @Query("SELECT * FROM notas ORDER BY id DESC")
    fun pegarTodasNotas():LiveData<List<Nota>>

}