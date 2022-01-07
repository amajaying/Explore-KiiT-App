package com.example.kiitappver2.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kiitappver2.model.Notes


@Dao
interface NotesDao {

    @Query("SELECT * from Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: Notes)
}