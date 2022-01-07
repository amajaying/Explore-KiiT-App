package com.example.kiitappver2.notes.NoteFragment

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kiitappver2.R
import com.example.kiitappver2.databinding.FragmentCreateNoteBinding
import com.google.gson.internal.bind.util.ISO8601Utils.format
import java.util.*


class CreateNoteFragment : Fragment() {

    private lateinit var binding:FragmentCreateNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)

        binding.saveNote.setOnClickListener {
            createNotes(it)
        }
        return binding.root
    }

    private fun createNotes(it: View?) {

        val title = binding.noteTitle.text
        val description = binding.noteDescription.text
        val d = Date()
        val  notesDate : CharSequence = DateFormat.format("MMMM d, yyyy ", d.getTime())


    }


}