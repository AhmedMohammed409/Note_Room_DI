package com.example.note_room_di.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.note_room_di.model.entity.Note


@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun addMassage(note: Note)
    @Delete
    suspend fun deleteMassage(note: Note)
    @Query("select *from Note_table")
     fun getAllMassage():List<Note>

}