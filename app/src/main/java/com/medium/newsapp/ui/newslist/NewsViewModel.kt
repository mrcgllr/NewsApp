package com.medium.newsapp.ui.newslist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medium.newsapp.model.Article
import com.medium.newsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _articlesLiveData: MutableLiveData<List<Article>> = MutableLiveData(emptyList())
    val articlesLivedata: LiveData<List<Article>> = _articlesLiveData

    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getArticles() = viewModelScope.launch {
        try {
            val response = newsRepository.getArticles()
            _articlesLiveData.value = response
        }catch (exception:Exception){
            _errorMessage.value = exception.localizedMessage
        }finally {
            _isLoading.value = false
        }
    }
}