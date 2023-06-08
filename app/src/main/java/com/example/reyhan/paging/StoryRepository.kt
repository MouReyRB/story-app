package com.example.reyhan.paging

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.reyhan.api.ApiInterface
import com.example.reyhan.database.StoryDatabase
import com.example.reyhan.viewmodel.ListStoryItem

class StoryRepository(private val storyDatabase: StoryDatabase
,private val apiInterface: ApiInterface) {
 fun getAllStories(token:String):LiveData<PagingData<ListStoryItem>>{
return Pager(
    config = PagingConfig(
        pageSize = 5
    ),
    pagingSourceFactory = {
        StorryPagingSource(apiInterface,token)
    }
).liveData
}

}