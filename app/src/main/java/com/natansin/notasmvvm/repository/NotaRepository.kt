package com.natansin.notasmvvm.repository

import com.natansin.notasmvvm.database.NotaDatabase
import com.natansin.notasmvvm.model.Nota

class NotaRepository(private val db:NotaDatabase) {



    suspend fun addNota(nota: Nota)= db.pegaNotaDao().addNota(nota)
    suspend fun atualizaNota(nota: Nota)= db.pegaNotaDao().atualizaNota(nota)
    suspend fun apagaNota(nota: Nota)= db.pegaNotaDao().apagaNota(nota)
    fun pegaTodasNotas()=db.pegaNotaDao().pegarTodasNotas()




}