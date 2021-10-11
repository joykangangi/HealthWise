package com.example.newsapi

data class Item(
    val Id: String,
    val ParentId: Int,
    val Title: String,
    val TranslationId: String,
    val Type: String
)