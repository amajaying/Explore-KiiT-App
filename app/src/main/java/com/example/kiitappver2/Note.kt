package com.example.kiitappver2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp


@Entity(tableName = "notesTable")
class Note(
    @ColumnInfo(name = "title") val noteTitle: String,
    @ColumnInfo(name = "description") val noteDesc: String,
    @ColumnInfo(name = "timeStamp") val timestamp: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}