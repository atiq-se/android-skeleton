package com.example.androidskeleton.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidskeleton.data.datamodels.Article
import com.example.androidskeleton.data.event.ArticleEvent
import com.example.androidskeleton.data.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject
constructor(private val articleRepository: ArticleRepository) : ViewModel() {

    // articles event...
    /***********************************************************************************/
    private val articlesEventChannel = Channel<ArticleEvent>()
    internal val articlesEvent = articlesEventChannel.receiveAsFlow()

    /***********************************************************************************/
    //private lateinit var _sharedItem : Article

    fun insertArticles(article: Article) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            articleRepository.insertArticle(article)
        }
    }

    fun getAllArticles() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            articlesEventChannel.send(ArticleEvent.Loading)
            articleRepository.getAllArticles().collect {
                articlesEventChannel.send(ArticleEvent.Articles(it))
            }
        }

    }

    /*fun updateItem(article: Article){
        _sharedItem = article
    }*/
//    fun getItem() = _sharedItem
}