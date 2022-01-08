package com.example.kiitappver2

import android.content.Intent
import android.net.Uri
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

        binding.socials.fb.setOnClickListener {
            val uri = Uri.parse("https://www.facebook.com/AchyutaSamanta")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.socials.twt.setOnClickListener {
            val uri = Uri.parse("https://twitter.com/achyuta_samanta")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.socials.insta.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/dr.achyutasamanta/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.socials.web.setOnClickListener {
            val uri = Uri.parse("https://achyutasamanta.com/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}