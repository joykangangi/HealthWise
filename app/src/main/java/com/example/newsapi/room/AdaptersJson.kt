package com.example.newsapi.room

import com.example.newsapi.Item
import com.example.newsapi.Items
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class AdaptersJson {
    inner class Items {
        @ToJson
        fun fullItems(item: Item) = item.Title

        @FromJson


    }
}