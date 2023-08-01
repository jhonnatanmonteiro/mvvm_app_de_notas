package com.natansin.notasmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.natansin.notasmvvm.model.Nota
import com.natansin.notasmvvm.repository.NotaRepository
import kotlinx.coroutines.launch

class NotaViewModel(
    app: Application,
    private val notaRepository: NotaRepository
): AndroidViewModel(app) {

    fun addNota(nota: Nota) = viewModelScope.launch {
        notaRepository.addNota(nota)
    }

    fun atualizaNota(nota: Nota)= viewModelScope.launch {
        notaRepository.atualizaNota(nota)
    }
    fun apagaNota(nota: Nota) = viewModelScope.launch {
        notaRepository.apagaNota(nota)
    }
    fun pegaTodasNotas() = notaRepository.pegaTodasNotas()


}