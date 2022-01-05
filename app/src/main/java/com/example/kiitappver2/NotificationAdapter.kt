package com.example.kiitappver2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import com.example.kiitappver2.Notification

class NotificationAdapter(private val notiList:ArrayList<Notification>):RecyclerView.Adapter<NotificationAdapter.NotiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_notification,parent,false)
        return NotiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotiViewHolder, position: Int) {
        val currentItem = notiList[position]
        holder.notiTitle.text = currentItem.notiTitle
        holder.notiDetail.text = currentItem.notiDetails
        holder.notiImage.setImageResource(currentItem.notiImage)
    }

    override fun getItemCount(): Int {
        return notiList.size
    }

    class NotiViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val notiTitle:TextView = itemView.findViewById(R.id.notiTitle)
        val notiDetail:TextView = itemView.findViewById(R.id.notiDetail)
        val notiImage:ImageView = itemView.findViewById(R.id.notiImage)
    }
}