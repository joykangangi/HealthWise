package com.example.healthwise.repository

import androidx.lifecycle.LiveData
import com.example.healthwise.models.Disease
import com.example.healthwise.room.ArticleDao

class MainRepository(private val diseaseDao: ArticleDao) {
    val allDisease: LiveData<List<Disease>> = diseaseDao.getAllArticles()

}


