package com.natansin.notasmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.natansin.notasmvvm.MainActivity
import com.natansin.notasmvvm.R
import com.natansin.notasmvvm.databinding.FragmentNovaNotaBinding
import com.natansin.notasmvvm.model.Nota
import com.natansin.notasmvvm.util.toast
import com.natansin.notasmvvm.viewmodel.NotaViewModel


class NovaNotaFragment : Fragment(R.layout.fragment_nova_nota) {
    private var _binding: FragmentNovaNotaBinding? = null
    private val binding get() = _binding!!

    private lateinit var notaViewModel: NotaViewModel
    private lateinit var mView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNovaNotaBinding.inflate(
            inflater,
            container,
            false

        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notaViewModel = (activity as MainActivity).notaViewModel

        mView= view
    }

    private fun salvarNota(view: View){
        val notaTitulo = binding.etNotaTitulo.text.toString().trim()
        val notaCorpo = binding.etNotaCorpo.text.toString().trim()

        if (notaTitulo.isEmpty()){
            val nota = Nota(0,notaTitulo, notaCorpo)

            notaViewModel.addNota(nota)
            Snackbar.make(view, "Nota salva",Snackbar.LENGTH_SHORT).show()
             view.findNavController().navigate(R.id.action_novaNotaFragment_to_inicioFragment)
        } else {
            activity?.toast("precisamos de um titulo para a nota")
        }
    }








    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.nova_nota_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.salva_menu -> {
                salvarNota(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}