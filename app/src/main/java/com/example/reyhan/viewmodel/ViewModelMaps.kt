package com.example.reyhan.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.reyhan.api.ApiClient
import com.example.reyhan.viewmodel.ListStoryItem
import com.example.reyhan.preferences.UserPreference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMaps(private val pref: UserPreference) : ViewModel() {

    private val _getAllStory = MutableLiveData<List<ListStoryItem>>()
    val getAllStory: LiveData<List<ListStoryItem>> get() = _getAllStory

    fun getToken(): LiveData<String> {
        return pref.getUserAuth().asLiveData()
    }

    fun getListMapsAll(token: String) {
        val client = ApiClient.getApiService().getAllMapsStory(token)
        client.enqueue(object : Callback<GetAllStories> {
            override fun onResponse(call: Call<GetAllStories>, response: Response<GetAllStories>) {
                if (response.isSuccessful) {
                    _getAllStory.value = response.body()?.listStory
                } else {
                    Log.d("onFailure", response.body()?.message.toString())
                }
            }

            override fun onFailure(call: Call<GetAllStories>, t: Throwable) {
                Log.d("onFailure", t.message.toString())
            }
        })
    }
}
