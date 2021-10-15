package com.example.newsapi.api

import com.example.newsapi.models.HealthResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HealthAPI {
    @GET("myhealthfinder/api/v3/itemlist.json?Type=topic")
    suspend fun generalTopics(
        @Query("language")
        language: String = "en",
        @Query("page")
        pageNumber:Int = 1
    ): Response<HealthResponse>

    @GET("myhealthfinder/api/v3/topicsearch.json")
    suspend fun searchTopics(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber:Int = 1
    ): Response<HealthResponse>
}