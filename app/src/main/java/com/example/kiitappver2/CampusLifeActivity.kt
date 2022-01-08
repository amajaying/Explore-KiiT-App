package com.example.kiitappver2

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
    }
}