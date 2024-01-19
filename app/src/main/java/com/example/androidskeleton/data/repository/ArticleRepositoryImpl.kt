package com.example.androidskeleton.data.repository

import com.example.androidskeleton.data.datamodels.Article
import com.example.androidskeleton.data.local.ArticleDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticleRepoImpl @Inject constructor(private val dao : ArticleDao) : ArticleRepository {
    override fun getAllArticles(): Flow<List<Article>> = flow{
        val articleList = dao.getArticlesFromDB()
        emit(articleList)
    }

    override fun insertArticle(article: Article) {
        dao.insertArticleIntoDB(article)
    }

}