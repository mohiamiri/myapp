package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.LocalDataSrc
import com.example.myapplication.database.RoomDB
import com.example.myapplication.database.daos.UserDao
import com.example.myapplication.repository.UserRepository
import com.example.myapplication.rest_api.RemoteDataSrc
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RoomDB {
        return Room.databaseBuilder(
            context,
            RoomDB::class.java,
            "RoomDB"
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(
        roomDB: RoomDB
    ): UserDao {
        return roomDB.userDao()
    }

    @Singleton
    @Provides
    fun provideRepository(
        local: LocalDataSrc,
        remote: RemoteDataSrc
    ): UserRepository {
        return UserRepository(local, remote)
    }
}