package com.example.note_room_di.model.repositry

import com.example.note_room_di.model.entity.Note


interface Repository {
     suspend fun addMassage(note: Note)

     suspend fun deleteMassage(note: Note )

     suspend fun getAllMassage():List<Note>
}