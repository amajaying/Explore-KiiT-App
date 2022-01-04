package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivityViewSocietyBinding

class ViewSocietyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewSocietyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewSocietyBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}