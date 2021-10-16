package com.example.newsapi.room

import androidx.room.TypeConverter
import com.example.newsapi.models.Items
import com.example.newsapi.models.Query
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class Converters {
    private val moshi: Moshi = Moshi.Builder().build()
    private val type: Type = Types.newParameterizedType(List::class.java, String::class.java)
    private val ownAdapter: JsonAdapter<Items> = moshi.adapter(Items::class.java)
    private val anotherAdapter: JsonAdapter<Query> = moshi.adapter(Query::class.java)
    private val adapter: JsonAdapter<Result> = moshi.adapter(type)

    @TypeConverter
    fun ownerToJson(items: Items): String = ownAdapter.toJson(items)

    @TypeConverter
    fun jsonToOwner(json: String): Items = ownAdapter.fromJson(json)!!

    @TypeConverter
    fun anotherToJson(query: Query): String = anotherAdapter.toJson(query)

    @TypeConverter
    fun jsonToAnother(json: String): Query = anotherAdapter.fromJson(json)!!



}