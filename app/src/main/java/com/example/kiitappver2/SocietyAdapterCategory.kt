package com.example.kiitappver2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.databinding.SocRowCategoryBinding


class SocietyAdapterCategory:RecyclerView.Adapter<SocietyAdapterCategory.HolderCategory> {

    private val context: Context
    private val categoryArrayList: ArrayList<SocietyModelCategory>



    private lateinit var binding: SocRowCategoryBinding

    constructor(context: SocietiesActivity, categoryArrayList: ArrayList<SocietyModelCategory>) {
        this.context = context
        this.categoryArrayList = categoryArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCategory {
        binding = SocRowCategoryBinding.inflate(LayoutInflater.from(context),parent, false)
        return HolderCategory(binding.root)
    }

    override fun onBindViewHolder(holder: HolderCategory, position: Int) {
        val model = categoryArrayList[position]
        val name = model.name

        holder.name.text = name

    }

    override fun getItemCount(): Int {
        return categoryArrayList.size
    }

    inner class HolderCategory(itemView: View): RecyclerView.ViewHolder(itemView){

        var name:TextView = binding.societyName
    }


}