package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.daos.UserDao
import com.example.myapplication.database.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class RoomDB: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: RoomDB? = null
        fun getInstance(
            context: Context
        ): RoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context, RoomDB::class.java, "RoomDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}