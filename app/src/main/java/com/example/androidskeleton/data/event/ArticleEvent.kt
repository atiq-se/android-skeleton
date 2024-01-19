package com.example.androidskeleton.data.event

import com.example.androidskeleton.data.datamodels.Article

sealed class ArticleEvent {
    object Loading : ArticleEvent()
    class Error(val error: String) : ArticleEvent()
    data class Articles(val articleList: List<Article>) : ArticleEvent()
}