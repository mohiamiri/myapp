package com.example.myapplication.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(

    @SerializedName(value = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @SerializedName(value = "name")
    val name: String
)
