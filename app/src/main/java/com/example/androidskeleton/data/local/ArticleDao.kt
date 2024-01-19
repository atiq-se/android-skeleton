package com.example.androidskeleton.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidskeleton.data.datamodels.Article

@Dao
interface ArticleDao {
    //Insert Article...
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticleIntoDB(article: Article)

    //Get Articles...
    @Query("Select * from Article")
    fun getArticlesFromDB():List<Article>
}