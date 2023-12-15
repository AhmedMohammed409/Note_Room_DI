package com.example.note_room_di.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    val nameNote: String,
    @ColumnInfo
    var note: String,
    @ColumnInfo
    var timeNote: String
)
