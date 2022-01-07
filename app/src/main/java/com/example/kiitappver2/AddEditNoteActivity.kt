package com.example.kiitappver2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kiitappver2.databinding.ActivityAddEditNoteBinding
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditNoteBinding

    lateinit var noteTitleEdit: EditText
    lateinit var noteDescriptionEdit: EditText
    lateinit var noteSavebtn: Button

    lateinit var viewModal: NoteViewModal
    var noteID = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteTitleEdit = binding.editNoteTitle
        noteDescriptionEdit = binding.editNoteDesc
        noteSavebtn = binding.saveNoteEdit

        viewModal = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        val noteType = intent.getStringExtra("noteType")
        if(noteType.equals("Edit")){
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDesc = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteID",-1)
            noteSavebtn.text = "Update Note"
            noteTitleEdit.setText(noteTitle)
            noteDescriptionEdit.setText(noteDesc)
        } else{
            noteSavebtn.text = "Save Note"
        }

        noteSavebtn.setOnClickListener {
            val noteTitle = noteTitleEdit.text.toString()
            val noteDescription = noteDescriptionEdit.text.toString()

            if(noteType.equals("Edit")){
                if(noteTitle.isNotEmpty() && noteDescription.isNotEmpty()){
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDate:String = sdf.format(Date())

                    val updateNote = Note(noteTitle, noteDescription, currentDate)
                    updateNote.id= noteID
                    viewModal.updateNote(updateNote)

                    Toast.makeText(this,"Note Updated!", Toast.LENGTH_LONG).show()

                }
            }else{
                if(noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDate: String = sdf.format(Date())

                    viewModal.addNote(Note(noteTitle, noteDescription, currentDate))

                    Toast.makeText(this, "Note Added!", Toast.LENGTH_LONG).show()
                }
            }
            startActivity(Intent(applicationContext,NotesActivity::class.java))
            this.finish()



    }
}

}