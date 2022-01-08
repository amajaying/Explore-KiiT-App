package com.example.kiitappver2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.Notification
import com.example.kiitappver2.NotificationAdapter
import com.example.kiitappver2.R
import com.example.kiitappver2.databinding.FragmentNotification2Binding
import kotlinx.android.synthetic.main.cardview_notification.view.*


class NotificationFragment : Fragment() {


    private lateinit var notiRecyclerView: RecyclerView
    private lateinit var notiArrayList: ArrayList<Notification>

    private lateinit var notiTitle: Array<String>
    private lateinit var notiDetail: Array<String>
    private lateinit var notiImage : Array<Int>

    private lateinit var binding: FragmentNotification2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotification2Binding.inflate(inflater, container, false)


        notiTitle = arrayOf(
            "Winter Vacation",
            "Winter Vacation"
        )


        notiDetail = arrayOf(
            "It is to be notified that winter vacation from Dec 21 to Jan2 is provided to the students.",
            "It is to be notified that winter vacation from Dec 21 to Jan2 is provided to the students."
        )

        notiImage = arrayOf(
            R.drawable.img_society_one,
            R.drawable.img_society_one
        )


        notiRecyclerView = binding.recyclerViewNotification
        notiRecyclerView.layoutManager = LinearLayoutManager(context)
        notiRecyclerView.setHasFixedSize(true)

        notiArrayList = arrayListOf<Notification>()
        getUserData()


         binding.recyclerViewNotification.setOnClickListener {

             Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
         }


        return binding.root
    }

    private fun getUserData() {
        for(i in notiImage.indices){
            val notification = Notification(notiTitle[i], notiDetail[i], notiImage[i])
            notiArrayList.add(notification)
        }
        val notificationAdapter = NotificationAdapter(notiArrayList)
        notiRecyclerView.adapter = notificationAdapter
    }

}