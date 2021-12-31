package com.example.kiitappwithinstaclone

import android.content.Intent
import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kiitappwithinstaclone.Fragments.AttendanceFragment
import com.example.kiitappwithinstaclone.Fragments.HomeFragment
import com.example.kiitappwithinstaclone.Fragments.NotificationFragment
import com.example.kiitappwithinstaclone.Fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {

    private var selectedFragment: Fragment ?= null


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                selectedFragment = HomeFragment()
            }
            R.id.attendance -> {
                selectedFragment = AttendanceFragment()

            }

            R.id.notification -> {
                selectedFragment = NotificationFragment()
            }
            R.id.profile -> {
                selectedFragment = ProfileFragment()
            }
        }

        if(selectedFragment != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,
                    selectedFragment!!
                ).commit()
        }

        false
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNav)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()




    }
}