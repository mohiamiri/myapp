package com.example.myapplication.database.daos

import androidx.room.*
import com.example.myapplication.database.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Update(entity = User::class)
    fun modify(user: User)

    @Delete(entity = User::class)
    fun deleteUser(user: User)

    @Query(value = "SELECT * FROM users ORDER BY name DESC")
    fun getAllUsers(): Flow<List<User>>

    @Query(value = "SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Flow<User>
}