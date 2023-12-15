package com.example.note_room_di

import com.example.note_room_di.model.entity.Note

interface OnListItemClick {
    fun onItemclick(note: Note)
}