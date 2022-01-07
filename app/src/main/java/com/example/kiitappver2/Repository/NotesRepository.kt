package com.example.kiitappver2.Repository

import androidx.lifecycle.LiveData
import com.example.kiitappver2.Dao.NotesDao
import com.example.kiitappver2.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes():LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }




}