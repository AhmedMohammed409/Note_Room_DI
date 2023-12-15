package com.example.note_room_di.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.note_room_di.models.Note

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMassage(note: Note)

    @Delete
    suspend fun deleteMassage(note: Note)

    @Query("select *from Note_table")
    fun getAllMassage(): LiveData<List<Note>>
}