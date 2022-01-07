package com.example.kiitappver2.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    var notes: String,
    var date: String
)