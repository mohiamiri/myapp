package com.example.myapplication.repositories

import com.example.myapplication.database.LocalDataSrc
import com.example.myapplication.rest_api.RemoteDataSrc
import com.example.myapplication.database.entities.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val local: LocalDataSrc,
    private val remote: RemoteDataSrc
) {
    suspend fun addUser(user: User) {
        local.addUser(user)
    }

    fun getUser(id: Int): Flow<User> {
        return local.getUser(id)
    }

    fun getAllUsers(): Flow<List<User>> {
        return local.getAllUsers()
    }

    suspend fun modifyUser(user: User) {
        local.modifyUser(user)
    }

    suspend fun deleteUser(user: User) {
        local.deleteUser(user)
    }

    suspend fun deleteUsers() {
        local.deleteUsers()
    }

    suspend fun fetchUsers(): List<User> = remote.fetchUsers()
}