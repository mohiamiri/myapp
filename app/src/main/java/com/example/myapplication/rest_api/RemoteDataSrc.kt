package com.example.myapplication.rest_api

import com.example.myapplication.database.entities.User
import retrofit2.http.GET
import javax.inject.Inject

class RemoteDataSrc @Inject constructor(
    private val retrofitService: RetrofitService
    ) {
    suspend fun fetchUsers() = retrofitService.fetchUsers()
}

interface RetrofitService {
    @GET("strings")
    suspend fun fetchUsers(): List<User>
}
