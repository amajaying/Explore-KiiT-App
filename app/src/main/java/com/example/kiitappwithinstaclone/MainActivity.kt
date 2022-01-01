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

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                moveToFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.attendance -> {
                moveToFragment(AttendanceFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.notification -> {
                moveToFragment(NotificationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                moveToFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNav)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        moveToFragment(HomeFragment())
    }

    private fun moveToFragment(fragment: Fragment)
    {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragmentContainer, fragment)
        fragmentTrans.commit()
    }
}