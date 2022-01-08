package com.example.kiitappver2.notes.NoteFragment

import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kiitappver2.R
import com.example.kiitappver2.ViewModel.NotesViewModel
import com.example.kiitappver2.databinding.FragmentEditNotesBinding
import com.example.kiitappver2.model.Notes
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*


class EditNotesFragment : Fragment() {

    val notes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    private val viewmodel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentEditNotesBinding.inflate(layoutInflater,container,false)

        binding.editNoteTitle.setText(notes.data.title)
        binding.editNoteDescription.setText(notes.data.notes)


        binding.editNote.setOnClickListener {
            updateNotes(it)
        }

        binding.backButton.setOnClickListener {
            Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_noteHomeFragment)

        }


        binding.deletebtn.setOnClickListener {
            val bottomSheet:BottomSheetDialog = BottomSheetDialog(requireContext(),R.style.BottomSheetStyle)
            bottomSheet.setContentView(R.layout.delete_dialog)

            val textviewYes=bottomSheet.findViewById<TextView>(R.id.yesbtn)
            val textviewNo=bottomSheet.findViewById<TextView>(R.id.nobtn)

            textviewYes?.setOnClickListener {
                viewmodel.deleteNotes(notes.data.id!!)
                bottomSheet.dismiss()
                Toast.makeText(context,"Note Deleted Successfully!", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_editNotesFragment_to_noteHomeFragment)

            }
            textviewNo?.setOnClickListener {
                bottomSheet.dismiss()
            }
            bottomSheet.show()
        }


        return binding.root
    }



    private fun updateNotes(it: View?) {

        val title = binding.editNoteTitle.text.toString()
        val description = binding.editNoteDescription.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.getTime())

        val data = Notes(
            notes.data.id,
            title = title,
            notes = description,
            date=notesDate.toString()
        )
        viewmodel.updateNotes(data)

        Toast.makeText(context,"Note Updated Successfully!", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_noteHomeFragment)




    }




}