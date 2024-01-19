package com.example.androidskeleton.di

import com.example.androidskeleton.data.network.apis.MyApi
import com.example.androidskeleton.data.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideAdsRepository(myApi: MyApi): MyRepository {
        return MyRepository(myApi)
    }
}