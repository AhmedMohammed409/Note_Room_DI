package com.example.note_room_di.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note_room_di.models.Note


@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class  UserDataBase:RoomDatabase() {

    abstract fun userDao(): UserDAO
    /*companion object{
        private var dbInstance:UserDataBase?=null
        fun getDataBaseInstance(context: Context): UserDataBase {
            if (dbInstance==null){
            return Room.databaseBuilder(
                context, UserDataBase::class.java, "Note_database").fallbackToDestructiveMigration().build()
        }
            return dbInstance!!
        }
    }*/
}
