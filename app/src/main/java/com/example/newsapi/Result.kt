package com.example.newsapi

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "articles"
)
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,//not all articles will retrieved will be saved into the db,
    // e.g those displayed in the search and common diseases tabs
    val Error: String,
    val Items: Items,
    val Language: String,
    val Query: Query,
    val Total: Int
)