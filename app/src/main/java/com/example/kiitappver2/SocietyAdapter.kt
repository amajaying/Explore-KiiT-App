package com.example.kiitappver2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class SocietyAdapter(private val societyList:ArrayList<Society>):RecyclerView.Adapter<SocietyAdapter.SocietyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocietyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.soc_row_category,parent,false)
        return SocietyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SocietyViewHolder, position: Int) {
        val currentItem = societyList[position]
        holder.name.text= currentItem.name
        holder.details.text = currentItem.details

        val isVisible : Boolean = currentItem.visibility
        holder.constraintLayout.visibility = if(isVisible) View.VISIBLE else View.GONE

        holder.tap.setOnClickListener{
            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }



    }

    override fun getItemCount(): Int {
        return societyList.size
    }


    class SocietyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.name)
        val details: TextView = itemView.findViewById(R.id.details)
        val constraintLayout:ConstraintLayout = itemView.findViewById(R.id.expandedLayout)
        val tap:RelativeLayout = itemView.findViewById(R.id.visibleLayout)
    }
}