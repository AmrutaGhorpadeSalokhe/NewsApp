package com.example.newsassessmentapplication.network

import com.example.newsassessmentapplication.model.NewsDataClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val apiInterface: ApiInterface) {

    val topNewsDataList = ArrayList<NewsDataClass>()

    suspend fun getTopNews() {
        withContext(Dispatchers.IO) {
            val users = apiInterface.getTopNews()
            topNewsDataList.addAll(users)
        }
    }
}