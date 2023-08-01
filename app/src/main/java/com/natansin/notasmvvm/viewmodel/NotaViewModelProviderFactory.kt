package com.natansin.notasmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.natansin.notasmvvm.repository.NotaRepository

class NotaViewModelProviderFactory(
    val app: Application,
    private val notaRepository: NotaRepository
): ViewModelProvider.Factory {
}