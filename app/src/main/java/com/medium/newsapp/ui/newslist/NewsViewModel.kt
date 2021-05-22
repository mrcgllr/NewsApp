package com.medium.newsapp.ui.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medium.newsapp.model.Article
import com.medium.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _articlesLiveData:MutableLiveData<List<Article>> = MutableLiveData()
    val articlesLivedata:LiveData<List<Article>>  = _articlesLiveData

    fun getArticles() = viewModelScope.launch{
        _articlesLiveData.value = newsRepository.getArticles()
    }
}