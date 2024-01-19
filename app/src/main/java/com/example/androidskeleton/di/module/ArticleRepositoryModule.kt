package com.example.androidskeleton.di.module

import com.example.androidskeleton.data.repository.ArticleRepoImpl
import com.example.androidskeleton.data.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ArticleRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindArticleRepository(articleRepoImpl: ArticleRepoImpl): ArticleRepository
}