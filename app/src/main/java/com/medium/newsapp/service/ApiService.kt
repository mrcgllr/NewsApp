package com.medium.newsapp.service

import com.medium.newsapp.model.Article
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines():List<Article>
}