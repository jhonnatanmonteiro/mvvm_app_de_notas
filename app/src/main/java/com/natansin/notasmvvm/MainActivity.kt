package com.natansin.notasmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.natansin.notasmvvm.database.NotaDatabase
import com.natansin.notasmvvm.databinding.ActivityMainBinding
import com.natansin.notasmvvm.repository.NotaRepository
import com.natansin.notasmvvm.viewmodel.NotaViewModel
import com.natansin.notasmvvm.viewmodel.NotaViewModelProviderFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var notaViewModel: NotaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

    }




    private fun configViewModel(){
        val notaRepository = NotaRepository(
            NotaDatabase(this)
        )
        val viewModelProviderFactory =
            NotaViewModelProviderFactory(
                application,
                notaRepository
            )

        notaViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        )[NotaViewModel::class.java]


    }
}