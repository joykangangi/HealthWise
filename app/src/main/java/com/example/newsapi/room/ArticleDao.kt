package com.example.newsapi.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapi.Result

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsertArticle(result: Result): Long //id inserted

   @Query("SELECT * FROM articles")
   fun getAllArticles(): LiveData<List<Result>>

   @Delete
   suspend fun deleteArticle(result: Result)

}