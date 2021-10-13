package com.example.newsapi.room

import com.example.newsapi.Items
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class Converters {
    private val type: Type = Types.newParameterizedType(List::class.java, String::class.java)
    private val moshi: Moshi = Moshi.Builder().build()

}