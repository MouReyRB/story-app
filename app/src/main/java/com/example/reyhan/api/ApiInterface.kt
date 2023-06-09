package com.example.reyhan.api

import com.example.reyhan.preferences.ErrorResponse
import com.example.reyhan.preferences.LoginResponse
import com.example.reyhan.viewmodel.GetAllStories
import com.example.reyhan.viewmodel.ListStoryItem
import okhttp3.MultipartBody
import okhttp3.RequestBody

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("v1/register")
    fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ErrorResponse>

    @FormUrlEncoded
    @POST("v1/login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @Multipart
    @POST("v1/stories")
    fun uploadStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<ErrorResponse>

    @GET("v1/stories")
    suspend fun getAllStories(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("location") location: Int? = null
    ): GetAllStories

    @GET("v1/stories")
     fun getAllMapsStory(
        @Header("Authorization")token: String
    ): Call<GetAllStories>


}