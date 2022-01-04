package com.example.kiitappver2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.databinding.ActivitySocietiesBinding
import com.google.firebase.database.*

class SocietiesActivity : AppCompatActivity() {

//    private lateinit var dbref : DatabaseReference
    private lateinit var societyRecyclerView: RecyclerView
    private lateinit var societyArrayList: ArrayList<Society>
    private lateinit var binding: ActivitySocietiesBinding

    lateinit var name: Array<String>
    lateinit var details: Array<String>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySocietiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            onBackPressed()
        }

        name = arrayOf(
            "Model Un Society",
            "Entrepreneurship Cell",
            "Qutopia - The Quizzing Society",
            "Korus - The Music & Dance Society",
            "Kiit Automobile Society",
            "Apogeio – The Aeronautical Society",
            "Kiit Robotics Society (KRS)",
            "Keurig - The Cooking Society",
            "Kreative Eye - The Photography & Painting Society",
            "Karma - Society For Differently Abled",
            "Kartavya - Social Responsibility Cell",
            "Kamakshi – The Women's Society",
            "Khetshan - International Students Society",
            "Khwahishein - The Hindi Society",
            "Film Society",
            "Kalakaar - The Dramatics Society",
            "Konnexions – Society For Web Development & It",
            "K-konnect - Society For Alumni Connect",
            "Kiit Wordsmith - The Writing Society",
            "Kzarshion - Fashion Society",
            "Kraya - Marketing Society",
            "Kuber - Finance Society",
            "Kimaya - Medical Society",
            "Science & Spiritual Society",
            "Society For Civil Engineering",
            "NCC",
            "NSS"
        )


        details = arrayOf(

            getString(R.string.s1),
            getString(R.string.s2),
            getString(R.string.s3),
            getString(R.string.s4),
            getString(R.string.s5),
            getString(R.string.s6),
            getString(R.string.s7),
            getString(R.string.s8),
            getString(R.string.s9),
            getString(R.string.s10),
            getString(R.string.s11),
            getString(R.string.s12),
            getString(R.string.s13),
            getString(R.string.s14),
            getString(R.string.s15),
            getString(R.string.s16),
            getString(R.string.s17),
            getString(R.string.s18),
            getString(R.string.s19),
            getString(R.string.s20),
            getString(R.string.s21),
            getString(R.string.s22),
            getString(R.string.s23),
            getString(R.string.s24),
            getString(R.string.s25),
            getString(R.string.s26),
            getString(R.string.s27)

        )



        societyRecyclerView = binding.societiesrv
        societyRecyclerView.layoutManager = LinearLayoutManager(this)
        societyRecyclerView.setHasFixedSize(true)

        societyArrayList = arrayListOf<Society>()
        getUserData()


    }

    private fun getUserData() {
        for(i in name.indices){
            val society = Society(name[i], details[i])
            societyArrayList.add(society)
        }
        val societyAdapter = SocietyAdapter(societyArrayList)
        societyRecyclerView.adapter = societyAdapter
    }


}