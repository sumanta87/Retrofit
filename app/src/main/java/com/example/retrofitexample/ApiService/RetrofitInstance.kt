package com.example.retrofitexample.ApiService

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: ApiService by lazy {

        val httpClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClientBuilder.build())
            .build()
            .create(ApiService::class.java)
    }
}