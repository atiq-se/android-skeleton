package com.example.androidskeleton.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidskeleton.data.datamodels.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class ArticleDataBase
    : RoomDatabase() {
    abstract fun ArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDataBase? = null
        private const val DB_NAME = "article_database.db"
        fun getInstance(context: Context): ArticleDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
