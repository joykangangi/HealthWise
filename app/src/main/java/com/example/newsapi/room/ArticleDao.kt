package com.example.newsapi.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapi.models.Disease

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun upsertArticle(disease: Disease): Long //id inserted

   @Query("SELECT * FROM diseases")
   fun getAllArticles(): LiveData<List<Disease>>

   @Delete
   suspend fun deleteArticle(disease: Disease)

}