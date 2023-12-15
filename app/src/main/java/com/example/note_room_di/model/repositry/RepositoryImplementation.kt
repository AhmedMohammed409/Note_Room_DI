package com.example.note_room_di.model.repositry

import com.example.note_room_di.model.entity.Note
import com.example.note_room_di.model.local.UserDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class RepositoryImplementation @Inject constructor(private var appDao:UserDAO): Repository {


    override suspend fun addMassage(note: Note) {
        withContext(Dispatchers.IO){
            appDao.addMassage(note)
        }

    }

    override suspend fun deleteMassage(note: Note) {
        withContext(Dispatchers.IO){
            appDao.deleteMassage(note)
        }

    }

    override suspend fun getAllMassage():List<Note>{
           return  appDao.getAllMassage()

    }
}