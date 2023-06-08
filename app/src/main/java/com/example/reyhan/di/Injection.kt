package com.example.reyhan.di

import android.content.Context
import com.example.reyhan.api.ApiClient
import com.example.reyhan.database.StoryDatabase
import com.example.reyhan.paging.StoryRepository

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val database = StoryDatabase.getDatabase(context)
        val apiService = ApiClient.getApiService()
        return StoryRepository(database, apiService)
    }
}