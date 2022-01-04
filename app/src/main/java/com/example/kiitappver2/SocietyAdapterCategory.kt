package com.example.kiitappver2

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.databinding.SocRowCategoryBinding


class SocietyAdapterCategory:RecyclerView.Adapter<SocietyAdapterCategory.HolderCategory> {

    private val context: Context
    private val categoryArrayList: ArrayList<SocietyModelCategory>



    private lateinit var binding: SocRowCategoryBinding

    constructor(context: Context, categoryArrayList: ArrayList<SocietyModelCategory>) {
        this.context = context
        this.categoryArrayList = categoryArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCategory {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HolderCategory, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class HolderCategory(itemView: View): RecyclerView.ViewHolder(itemView){

        var name:TextView = binding.societyName
    }


}