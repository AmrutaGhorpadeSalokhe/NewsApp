package com.example.newsassessmentapplication.network

import com.example.newsassessmentapplication.model.NewsDataClass
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/v2/top-headlines/sources?category=business&apiKey=597532faa5794a95a79461ea1fceb839")
    suspend fun getTopNews():List<NewsDataClass>



}