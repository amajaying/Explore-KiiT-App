package com.example.kiitappver2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivityCampusLifeBinding

class CampusLifeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCampusLifeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCampusLifeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            onBackPressed()
        }


        binding.learnmore.setOnClickListener {
            val uri = Uri.parse("https://kiit.ac.in/campuslife/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}