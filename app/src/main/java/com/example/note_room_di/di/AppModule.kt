package com.example.note_room_di.di

import android.app.Application
import com.example.note_room_di.model.local.UserDAO
import com.example.note_room_di.model.local.UserDataBase
import com.example.note_room_di.model.repositry.RepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getDataBase( application:Application):UserDataBase{
        return UserDataBase.getDataBaseInstance(application)
    }

    @Provides
    @Singleton
    fun getDAO(db:UserDataBase):UserDAO{
        return db.userDao()
    }
    @Provides
    @Singleton
    fun getRepositoryImp(userDAO: UserDAO):RepositoryImplementation{
        return RepositoryImplementation(userDAO)
    }


}
