package com.example.reyhan.viewmodel

import android.app.Application
import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.reyhan.camera.ViewModelAddstory
import com.example.reyhan.di.Injection
import com.example.reyhan.preferences.UserPreference

class ViewModelFactory(private val pref: UserPreference,private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {




    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(pref) as T
        }
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(pref,Injection.provideRepository(context)) as T
        }
        if (modelClass.isAssignableFrom(ViewModelAddstory::class.java)) {
            return ViewModelAddstory(pref) as T
        }
        if (modelClass.isAssignableFrom(ViewModelLogout::class.java)) {
            return ViewModelLogout(pref) as T
        }
        if(modelClass.isAssignableFrom(ViewModelMaps::class.java)){
            return ViewModelMaps(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}