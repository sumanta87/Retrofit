package com.example.retrofitexample.ApiService

import com.example.retrofitexample.Model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPost(): List<Post>
}