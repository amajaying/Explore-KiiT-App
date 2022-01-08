package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivityAcademicsBinding

class AcademicsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAcademicsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAcademicsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backButton.setOnClickListener{
            onBackPressed()
        }
    }
}