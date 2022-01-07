package com.example.kiitappver2.notes.NoteFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kiitappver2.R
import com.example.kiitappver2.databinding.FragmentNoteHome2Binding


class NoteHomeFragment : Fragment() {

    private lateinit var binding: FragmentNoteHome2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentNoteHome2Binding.inflate(layoutInflater, container, false)

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_noteHomeFragment_to_createNoteFragment)
        }

        return binding.root

    }

}