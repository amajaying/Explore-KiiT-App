package com.example.kiitappver2.notes.NoteFragment

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.kiitappver2.Model.Notes
import com.example.kiitappver2.R
import com.example.kiitappver2.ViewModel.NotesViewModel
import com.example.kiitappver2.databinding.FragmentCreateNoteBinding
import com.google.gson.internal.bind.util.ISO8601Utils.format
import kotlinx.android.synthetic.main.soc_row_category.*
import java.util.*


class CreateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding
    val viewmodel: NotesViewModel by viewModels()

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

        val title = binding.noteTitle.text.toString()
        val description = binding.noteDescription.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.getTime())

        val data = Notes(
            null, title = title,
            notes = description,
            date=notesDate.toString()
        )
        viewmodel.addNotes(data)

        Toast.makeText(context,"Note Created Successfully!", Toast.LENGTH_SHORT).show()



    }


}