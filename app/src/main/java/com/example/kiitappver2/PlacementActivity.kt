package com.example.kiitappver2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappver2.databinding.ActivityPlacementBinding

class PlacementActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPlacementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacementBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.backButton.setOnClickListener{
            onBackPressed()
        }

        binding.learnmore.setOnClickListener {
            val uri = Uri.parse("https://kiit.ac.in/training-placement/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}