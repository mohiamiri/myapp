package com.example.myapplication.database.daos

import androidx.room.*
import com.example.myapplication.database.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun modifyUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query(value = "SELECT * FROM users ORDER BY name DESC")
    fun getAllUsers(): Flow<List<User>>

    @Query(value = "SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Flow<User>
}