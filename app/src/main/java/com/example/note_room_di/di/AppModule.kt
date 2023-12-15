package com.example.note_room_di.di

import android.content.Context
import androidx.room.Room
import com.example.note_room_di.db.UserDAO
import com.example.note_room_di.db.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getDataBase(@ApplicationContext context: Context): UserDataBase {
//        return UserDataBase.getDataBaseInstance(context)
        return Room
            .databaseBuilder(context, UserDataBase::class.java, "Note_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun getDAO(db: UserDataBase): UserDAO {
        return db.userDao()
    }

    /*@Provides
    @Singleton
    fun getRepositoryImp(userDAO: UserDAO): RepositoryImplementation {
        return RepositoryImplementation(userDAO)
    }*/
}
