package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivitySocietiesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SocietiesActivity : AppCompatActivity() {

    private lateinit var categoryArrayList: ArrayList<SocietyModelCategory>
    private lateinit var adapterCategory: SocietyAdapterCategory
    private lateinit var binding: ActivitySocietiesBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_societies)

        firebaseAuth = FirebaseAuth.getInstance()
        loadCategories()
    }

    private fun loadCategories() {
        categoryArrayList = ArrayList()

        val ref = FirebaseDatabase.getInstance().getReference("Societies")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                categoryArrayList.clear()
                for (ds in snapshot.children){
                    val model = ds.getValue(SocietyModelCategory::class.java)

                    categoryArrayList.add(model!!)
                }

                adapterCategory = SocietyAdapterCategory(this@SocietiesActivity, categoryArrayList)

                binding.societiesrv.adapter = adapterCategory
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}