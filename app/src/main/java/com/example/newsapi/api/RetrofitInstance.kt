package com.example.newsapi.api

import com.example.newsapi.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor() //track responses & requests
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)//see response
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val api: HealthAPI by lazy {
            retrofit.create(HealthAPI::class.java)//why can't we create this in retrofit
        }
    }
}