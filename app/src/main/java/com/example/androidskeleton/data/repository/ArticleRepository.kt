package com.example.androidskeleton.data.repository

import com.example.androidskeleton.data.datamodels.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getAllArticles() : Flow<List<Article>>
    fun insertArticle(article: Article)
}

