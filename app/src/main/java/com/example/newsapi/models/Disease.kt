package com.example.newsapi.models

import androidx.room.Entity

@Entity(tableName = "diseases")
data class Disease(
    val data_updated_at: String,
    val diagnosis: Any,
    val facts: List<String>,
    val id: Int,
    val is_active: Boolean,
    val more: String,
    val name: String,
    val prevention: Any,
    val symptoms: Any,
    val transmission: Any,
    val treatment: Any
)