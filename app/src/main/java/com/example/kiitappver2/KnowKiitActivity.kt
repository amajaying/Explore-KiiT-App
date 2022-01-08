package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivityKnowKiitBinding

class KnowKiitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKnowKiitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKnowKiitBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.backButton.setOnClickListener{
            onBackPressed()
        }
    }
}