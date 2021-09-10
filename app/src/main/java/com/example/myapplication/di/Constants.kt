package com.example.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Constants {

    private val baseUrl = "https://appteck.mpsservice.net/v11.1/strings.php/"

    @Singleton
    @Provides
    fun provideUrlString(): String = baseUrl
}