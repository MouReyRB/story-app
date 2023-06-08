package com.example.reyhan.preferences

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("error")
    val error: Boolean?=null,
    @field:SerializedName("message")
    val message:String?=null,
    @field:SerializedName("loginResult")
    val loginResult: User?=null
)
