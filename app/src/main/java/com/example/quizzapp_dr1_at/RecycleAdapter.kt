package com.example.quizzapp_dr1_at

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lista_layout.view.*

class RecycleAdapter (private val arrayList:ArrayList<ListaModel>, val context: Context):
    RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {


        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bindItems(listaModel: ListaModel) {
                itemView.textview_lista.text = listaModel.texto
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.lista_layout, parent, false)

            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItems(arrayList[position])
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }

}