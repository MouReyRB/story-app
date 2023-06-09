package com.example.reyhan.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.reyhan.api.ApiClient
import com.example.reyhan.paging.StoryRepository
import com.example.reyhan.preferences.UserPreference
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(
    private val pref: UserPreference
    , private val storyRepository: StoryRepository
) : ViewModel() {

    private val _listory = MutableLiveData<List<ListStoryItem>>()
    val listory: LiveData<List<ListStoryItem>> = _listory

    fun getTheListStories(token: String): LiveData<PagingData<ListStoryItem>> =
        storyRepository.getAllStories(token).cachedIn(viewModelScope)




    fun getToken(): LiveData<String> {
        return pref.getUserAuth().asLiveData()
    }

    fun saveToken(token: String) {
        viewModelScope.launch {
            pref.saveUserAuth(token)
        }
    }



}