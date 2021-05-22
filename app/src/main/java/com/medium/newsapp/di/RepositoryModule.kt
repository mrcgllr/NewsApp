package com.medium.newsapp.di

import com.medium.newsapp.repository.NewsRepository
import com.medium.newsapp.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun getNewsRepository(apiService: ApiService):NewsRepository{
        return NewsRepository(apiService)
    }
}