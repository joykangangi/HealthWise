package com.example.newsapi

data class Result(
    val Error: String,
    val Items: Items,
    val Language: String,
    val Query: Query,
    val Total: Int
)