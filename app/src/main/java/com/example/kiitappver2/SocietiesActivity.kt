package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.databinding.ActivitySocietiesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class SocietiesActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var societyRecyclerView: RecyclerView
    private lateinit var societyArrayList: ArrayList<Society>
    private lateinit var binding: ActivitySocietiesBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySocietiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        societyRecyclerView = binding.societiesrv
        societyRecyclerView.layoutManager = LinearLayoutManager(this)
        societyRecyclerView.setHasFixedSize(true)

        societyArrayList = arrayListOf<Society>()
        getSocietyData()


    }

    private fun getSocietyData() {
        dbref = FirebaseDatabase.getInstance().getReference("Societies")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(societySnapshot in snapshot.children){

                        val society = societySnapshot.getValue(Society::class.java)
                        societyArrayList.add(society!!)
                    }
                    societyRecyclerView.adapter = SocietyAdapter(this@SocietiesActivity,societyArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }


}