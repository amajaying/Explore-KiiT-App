package com.example.kiitappver2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SocietyAdapter(private val societyList : ArrayList<Society>) : RecyclerView.Adapter<SocietyAdapter.SocietyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocietyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.soc_row_category, parent, false)
        return SocietyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SocietyViewHolder, position: Int) {
       val currentItem = societyList[position]
        holder.name.text = currentItem.name

    }

    override fun getItemCount(): Int {
        return societyList.size
    }

    class SocietyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name)
        val image:ImageView = itemView.findViewById(R.id.societylogo)
    }
}