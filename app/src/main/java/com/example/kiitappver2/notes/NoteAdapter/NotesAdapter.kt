package com.example.kiitappver2.notes.NoteAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kiitappver2.R
import com.example.kiitappver2.model.Notes
import com.example.kiitappver2.databinding.ItemNotesBinding
import com.example.kiitappver2.notes.NoteFragment.NoteHomeFragmentDirections

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {
    class notesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesDetail.text = data.notes
        holder.binding.notesDate.text = data.date

        holder.binding.root.setOnClickListener {
            val action = NoteHomeFragmentDirections.actionNoteHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)
        }


    }



    override fun getItemCount() = notesList.size


}