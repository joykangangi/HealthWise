package com.example.newsapi.models

data class Item(
    val Id: String,
    val ParentId: Int,
    val Title: String,
    val TranslationId: String,
    val Type: String
)