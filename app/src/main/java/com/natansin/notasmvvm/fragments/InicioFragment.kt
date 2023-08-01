package com.natansin.notasmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.findNavController
import com.natansin.notasmvvm.MainActivity
import com.natansin.notasmvvm.R
import com.natansin.notasmvvm.adapter.NotaAdapter
import com.natansin.notasmvvm.databinding.FragmentInicioBinding
import com.natansin.notasmvvm.viewmodel.NotaViewModel


class InicioFragment : Fragment(R.layout.fragment_inicio) {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    private lateinit var notaViewModel: NotaViewModel

    private lateinit var notaAdapter: NotaAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        binding.fabAdd.setOnClickListener{mView ->
            mView.findNavController().navigate(R.id.action_inicioFragment_to_novaNotaFragment)

        }
    }








    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.inicio_menu, menu)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}