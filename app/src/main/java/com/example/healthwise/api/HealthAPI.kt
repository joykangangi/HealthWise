package com.example.healthwise.api

import com.example.healthwise.models.Disease
import com.example.healthwise.models.HealthResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface HealthAPI {
    @GET("/diseases.json")
    suspend fun generalTopics(
        @Query("page")
        pageNumber:Int = 1
    ): Response<HealthResult>

    @GET("/diseases.json")
    suspend fun searchTopics(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber:Int = 1
    ): Response<Disease>
}