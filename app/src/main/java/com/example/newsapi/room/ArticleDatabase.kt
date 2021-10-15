package com.example.newsapi.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Database( entities = [Result::class], exportSchema = false, version = 1)

abstract class ArticleDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile //visible to other threads
        private var instance: ArticleDatabase? = null  //singleton
        private val LOCK = Any() //single instance at a time

        //synchronized to ensure one thread at a time/thread safety
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{ instance = it }

        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()

    }
}