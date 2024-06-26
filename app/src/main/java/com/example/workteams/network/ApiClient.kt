package com.example.workteams.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {


    //    private const val BASE_URL = "https://backend-api-2zsu.onrender.com/api/schema/"
    private const val BASE_URL = "https://backend-api-2zsu.onrender.com/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}

object ApiClient {
    val apiService: UserService by lazy {
        RetrofitClient.retrofit.create(UserService::class.java)
    }
}