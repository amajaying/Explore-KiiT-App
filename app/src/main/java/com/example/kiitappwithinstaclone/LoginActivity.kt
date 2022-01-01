package com.example.kiitappwithinstaclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappwithinstaclone.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}