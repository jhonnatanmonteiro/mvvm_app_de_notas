package com.natansin.notasmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.natansin.notasmvvm.databinding.NotaAdapterLayoutBinding
import com.natansin.notasmvvm.model.Nota

class NotaAdapter: RecyclerView.Adapter<NotaAdapter.NotaViewHolder>() {

    private var binding: NotaAdapterLayoutBinding? = null

    class NotaViewHolder(itemBinding: NotaAdapterLayoutBinding):
            RecyclerView.ViewHolder(itemBinding.root)

    private val differcallback =
        object : DiffUtil.ItemCallback<Nota>(){
            override fun areItemsTheSame(oldItem: Nota, newItem: Nota): Boolean {
                return oldItem.id ==newItem.id
            }

            override fun areContentsTheSame(oldItem: Nota, newItem: Nota): Boolean {
                return oldItem == newItem
            }

        }
    val differ = AsyncListDiffer(this,differcallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        binding = NotaAdapterLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return  NotaViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
    return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val currentNota = differ.currentList[position]

        holder.itemView.apply {
            binding?.tvNotaTitulo?.text = currentNota.notaTitulo
            binding?.tvNotaCorpo?.text = currentNota.notaCorpo
        }
    }
}