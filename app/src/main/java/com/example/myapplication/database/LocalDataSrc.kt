package com.example.myapplication.database

import com.example.myapplication.database.daos.UserDao
import com.example.myapplication.database.entities.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSrc @Inject constructor(
    private val userDao: UserDao
) {
    fun getUser(id: Int): Flow<User> = userDao.getUser(id)

    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()

    suspend fun addUser(user: User) { userDao.addUser(user) }

    suspend fun modifyUser(user: User) { userDao.modifyUser(user) }

    suspend fun deleteUser(user: User) { userDao.deleteUser(user) }

    suspend fun deleteUsers() { userDao.deleteUsers() }
}
