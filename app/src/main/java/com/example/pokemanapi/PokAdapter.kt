package com.example.pokemanapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.each_row.view.*

class  PokAdapter(val context: Context,val newlist:ArrayList<Myclass> ) : RecyclerView.Adapter<PokAdapter.PokHolder>()
{

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PokAdapter.PokHolder {
    val  view=LayoutInflater.from(context).inflate(R.layout.each_row,p0,false)
        return PokHolder(view)
    }

    override fun getItemCount(): Int {
    return  newlist.size
    }

    override fun onBindViewHolder(p0: PokAdapter.PokHolder, p1: Int) {
        val current=newlist[p1]
        p0.tvname.text= current.name
        p0.itemView.tvurl.text= current.weight.toString()
    }
    class PokHolder(itemView:View) : RecyclerView.ViewHolder( itemView)
    {
        internal var tvname:TextView = itemView.tvname.findViewById(R.id.tvname)
    }


}