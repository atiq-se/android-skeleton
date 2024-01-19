package com.example.androidskeleton.di

import com.example.androidskeleton.data.network.RemoteDataSource
import com.example.androidskeleton.data.network.apis.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideAdsApi(
        remoteDataSource: RemoteDataSource
    ): MyApi {
        return remoteDataSource.buildApi(MyApi::class.java)
    }
}