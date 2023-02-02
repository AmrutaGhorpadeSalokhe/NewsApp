package com.example.newsassessmentapplication

import android.app.Application
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newsassessmentapplication.network.ApiInterface
import com.example.newsassessmentapplication.network.Repository
import com.example.newsassessmentapplication.viewmodel.NewsViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import org.koin.core.module.Module
import org.koin.dsl.module
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import get
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { NewsViewModel(get()) }
}


val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    single { provideUserApi(get()) }
}

val netModule = module {

    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }


    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    single { provideHttpClient(get()) }
    single { provideGson() }
    single { provideRetrofit(get(), get()) }

}


val repositoryModule = module {
    fun provideUserRepository(api: ApiInterface): Repository {
        return Repository(api)
    }

    single { provideUserRepository(get(), get()) }
}