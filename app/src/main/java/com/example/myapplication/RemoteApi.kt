package com.example.myapplication

import com.example.myapplication.database.entities.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://appteck.mpsservice.net/v11.1/strings.php/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RetrofitService {
    @GET("strings")
    suspend fun fetchStrings(): List<User>
}

object RemoteApi {
    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}

/*
interface ApiInterface {

    @GET("volley_array.json")
    fun getMovies() : Call<List<Stringy>>

    companion object {

        var BASE_URL = "http://velmm.com/apis/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}
*/
