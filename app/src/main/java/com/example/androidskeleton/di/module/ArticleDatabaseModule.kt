package com.example.androidskeleton.di.module

import android.content.Context
import com.example.androidskeleton.data.local.ArticleDao
import com.example.androidskeleton.data.local.ArticleDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ArticleDatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ArticleDataBase {
        return ArticleDataBase.getInstance(context)
    }

    @Provides
    fun provideArticleDao(articleDataBase: ArticleDataBase): ArticleDao {
        return articleDataBase.ArticleDao()
    }
}