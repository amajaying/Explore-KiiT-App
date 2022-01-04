package com.example.kiitappver2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kiitappver2.databinding.ActivityNoLoginMainBinding

import com.example.kiitappver2.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class NoLoginActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                moveToFragment(NoLoginHomeFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.profile -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    private lateinit var binding: ActivityNoLoginMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = findViewById(R.id.bottomNavnologin)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        moveToFragment(NoLoginHomeFragment())


    }

    private fun moveToFragment(fragment: Fragment)
    {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragmentContainer, fragment)
        fragmentTrans.commit()
    }
}