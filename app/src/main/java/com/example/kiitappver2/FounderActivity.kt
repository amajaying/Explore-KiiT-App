package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivityFounderBinding
import com.example.kiitappver2.databinding.ActivitySocietiesBinding


class FounderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFounderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFounderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            onBackPressed()
        }
    }
}