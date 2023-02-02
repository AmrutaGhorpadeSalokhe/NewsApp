package com.example.newsassessmentapplication.model

import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsDataClass(
    val id:String,
    val name:String,
    val description:String,
    val url:String,
    val category:String,
    val language:String,
    val country:String
    )
