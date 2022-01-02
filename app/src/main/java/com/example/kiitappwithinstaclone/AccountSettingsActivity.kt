package com.example.kiitappwithinstaclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappwithinstaclone.databinding.ActivityAccountSettingsBinding
import android.content.Intent

import android.net.Uri
import com.google.firebase.database.FirebaseDatabase


class AccountSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            onBackPressed()
        }

        binding.gotoPortal.setOnClickListener{
            val uri = Uri.parse("https://kiitportal.kiituniversity.net/irj/portal/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private fun userInfo()
    {
        val usersRef = FirebaseDatabase.getInstance().reference.child("Users")
    }
}