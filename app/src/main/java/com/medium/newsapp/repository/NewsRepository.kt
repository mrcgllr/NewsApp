package com.medium.newsapp.repository

import com.medium.newsapp.model.Article
import com.medium.newsapp.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepository @Inject constructor(private val network: ApiService) {


    suspend fun getArticles(): List<Article> = withContext(Dispatchers.IO) {
        network.getTopHeadlines()
    }
}
