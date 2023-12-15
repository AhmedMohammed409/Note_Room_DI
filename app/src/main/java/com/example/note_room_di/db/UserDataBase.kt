package com.example.note_room_di.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note_room_di.models.Note


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class  UserDataBase:RoomDatabase() {
    abstract fun userDao(): UserDAO
}
