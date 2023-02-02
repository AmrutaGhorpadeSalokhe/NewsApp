package com.example.newsassessmentapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.newsassessmentapplication.R
import com.example.newsassessmentapplication.databinding.ActivityMainBinding
import com.example.newsassessmentapplication.network.LoadingState
import com.example.newsassessmentapplication.network.LoadingState.*
import com.example.newsassessmentapplication.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private val newsViewModel by viewModel<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        observeData()
    }
    private fun observeData(){
        newsViewModel.topNewsDataList.observe(this, Observer {


        })

        newsViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }




}