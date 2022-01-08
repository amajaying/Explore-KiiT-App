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
    private lateinit var notiImage: Array<Int>

    private lateinit var binding: FragmentNotification2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotification2Binding.inflate(inflater, container, false)


        notiTitle = arrayOf(
            "KISS-DU Organizes Webinar On ‘Greening Of Romanticism And Romanticization Of Greenness: A Reading Of Wordsworth And Tagore From Eco-Theological Perspective’",
            "76 Professors Promoted",
"KIIT Wins ‘THE Awards Asia 2021’In ‘Leadership And Management Team Of The Year’ Category"

        )


        notiDetail = arrayOf(
            "The School of Comparative Tribal Language and Literature (English Programme) at KISS Deemed to be University organized a webinar on ‘Greening of Romanticism and Romanticization of Greenness: A Reading of Wordsworth and Tagore from Eco-theological Perspective’ on 28th December 2021. Professor Goutam Buddha Sural, Department of English, Bankura University, was invited as the distinguished speaker.",
            "Prof. Sasmita Samanta, Vice Chancellor, KIIT Deemed to be University handed over the letters of promotion to as many as 76 eligible professors of the KIIT Deemed to be University at a Special Ceremony on 31st December, 2021.",
"Kalinga Institute of Industrial Technology (KIIT) Deemed to be University, Bhubaneswar has been awarded ‘THE Awards Asia’ Leadership and Management Team of the Year for its phenomenal pandemic response and relief work. The award was announced by the Times Higher Education (THE) on 14th December 2021. KIIT is the only University from India and also the only university in Asia to get this award"
            )

        notiImage = arrayOf(
            R.drawable.event1,
            R.drawable.event2,
            R.drawable.event3

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
        for (i in notiImage.indices) {
            val notification = Notification(notiTitle[i], notiDetail[i], notiImage[i])
            notiArrayList.add(notification)
        }
        val notificationAdapter = NotificationAdapter(notiArrayList)
        notiRecyclerView.adapter = notificationAdapter
    }

}