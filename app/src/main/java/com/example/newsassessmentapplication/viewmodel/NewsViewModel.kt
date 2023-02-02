package com.example.newsassessmentapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsassessmentapplication.network.LoadingState
import com.example.newsassessmentapplication.network.Repository
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: Repository):ViewModel() {
    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    val topNewsDataList = repository.topNewsDataList

    init {
        fetchTopNewsData()
    }

    private fun fetchTopNewsData() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                repository.getTopNews()
                _loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                _loadingState.value = LoadingState.error(e.message)
            }
        }
    }
}

