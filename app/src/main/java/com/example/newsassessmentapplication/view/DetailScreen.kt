package com.example.newsassessmentapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.newsassessmentapplication.viewmodel.NewsViewModel

class DetailScreen : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding=DataBindingUtil.setContentView(this,R.activity_detail_screen)
    }
}