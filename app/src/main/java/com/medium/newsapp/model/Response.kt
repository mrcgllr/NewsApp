package com.medium.newsapp.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("status")
    val status:String,
    @SerializedName("totalResults")
    val totalResults:Int,
    @SerializedName("articles")
    val articles:List<Article>
)