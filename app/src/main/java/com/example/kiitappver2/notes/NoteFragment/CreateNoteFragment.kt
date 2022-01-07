package com.example.kiitappver2.notes.NoteFragment

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.kiitappver2.model.Notes
import com.example.kiitappver2.R
import com.example.kiitappver2.ViewModel.NotesViewModel
import com.example.kiitappver2.databinding.FragmentCreateNoteBinding
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

        binding.backButton.setOnClickListener {
            Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_noteHomeFragment)
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

        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_noteHomeFragment)



    }


}