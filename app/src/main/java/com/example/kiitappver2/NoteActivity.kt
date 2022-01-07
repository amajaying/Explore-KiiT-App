package com.example.kiitappver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kiitappver2.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    lateinit var binding:ActivityNoteBinding
    lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController=findNavController(R.id.fragmentContainerView)

//        setupActionBarWithNavController(navController)
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}