package com.example.kiitappwithinstaclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappwithinstaclone.databinding.ActivityAccountSettingsBinding


class AccountSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}