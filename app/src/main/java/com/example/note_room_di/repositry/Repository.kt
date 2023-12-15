package com.example.note_room_di.repositry

import androidx.lifecycle.LiveData
import com.example.note_room_di.models.Note

interface Repository {
    suspend fun addMassage(note: Note)

    suspend fun deleteMassage(note: Note)

    fun getAllMassage(): LiveData<List<Note>>
}