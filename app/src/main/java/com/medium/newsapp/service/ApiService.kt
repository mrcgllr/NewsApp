package com.medium.newsapp.service

import com.medium.newsapp.model.Article
import com.medium.newsapp.model.Response
import com.medium.newsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country:String = "tr"
    ):Response
}