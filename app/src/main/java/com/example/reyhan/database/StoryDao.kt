package com.example.reyhan.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reyhan.viewmodel.ListStoryItem

//@Dao
//interface StoryDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertQuote(quote: List<ListStoryItem>)
//
//    @Query("SELECT * FROM storiesapp")
//    fun getAllQuote(): PagingSource<Int, ListStoryItem>
//
//    @Query("DELETE FROM storiesapp")
//    suspend fun deleteAll()
//}