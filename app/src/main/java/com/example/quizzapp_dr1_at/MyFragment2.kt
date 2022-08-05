package com.example.quizzapp_dr1_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_my2.*


class MyFragment2 : Fragment() {


    private var recycleadapter:RecyclerView.Adapter<RecycleAdapter.ViewHolder>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_my2, container, false)


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val arrayList = ArrayList<ListaModel>()
        arrayList.add(ListaModel("Primeiro Item da Lista"))
        arrayList.add(ListaModel("Segundo Item da Lista"))
        arrayList.add(ListaModel("Terceiro Item da Lista"))

        recyclerview.adapter = recycleadapter
        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecycleAdapter(arrayList, this.context)
        }
    }
}