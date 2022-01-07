package com.example.kiitappver2.notes.NoteFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kiitappver2.MainActivity
import com.example.kiitappver2.R
import com.example.kiitappver2.ViewModel.NotesViewModel
import com.example.kiitappver2.databinding.FragmentNoteHome2Binding
import com.example.kiitappver2.notes.NoteAdapter.NotesAdapter


class NoteHomeFragment : Fragment() {

    private lateinit var binding: FragmentNoteHome2Binding
    val viewmodel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentNoteHome2Binding.inflate(layoutInflater, container, false)

        viewmodel.getNotes().observe(viewLifecycleOwner,{notesList->
            binding.rvAllNotes.layoutManager= GridLayoutManager(requireContext(),2)
            binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
        })

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_noteHomeFragment_to_createNoteFragment)
        }

        binding.backButton.setOnClickListener {
            startActivity(Intent(context,MainActivity::class.java))
        }

        return binding.root

    }

}