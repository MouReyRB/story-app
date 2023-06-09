package com.example.reyhan.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.reyhan.preferences.UserPreference
import kotlinx.coroutines.launch

class ViewModelAddstory(private val pref: UserPreference) : ViewModel() {
    fun getToken(): LiveData<String> {
        return pref.getUserAuth().asLiveData()
    }

    fun saveToken(token: String) {
        viewModelScope.launch {
            pref.saveUserAuth(token)
        }
    }
}