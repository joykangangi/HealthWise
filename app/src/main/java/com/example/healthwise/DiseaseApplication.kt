package com.example.healthwise

import android.app.Application
import com.example.healthwise.repository.MainRepository
import com.example.healthwise.room.ArticleDatabase


/**
 * For only one instance of the database and of the repository in the app.
 * An easy way to achieve this is by creating them as members of the Application class.
 * Then they will just be retrieved from the Application whenever they're needed, rather than constructed every time.
 */

class DiseaseApplication: Application() {

    private val database by lazy { ArticleDatabase(this) }
    val repository by lazy { MainRepository( database.getArticleDao() ) }

}