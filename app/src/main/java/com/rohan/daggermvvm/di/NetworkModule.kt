package com.rohan.daggermvvm.di.com.rohan.daggermvvm.di

import com.rohan.daggermvvm.Retrofit.WebService
import com.rohan.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getWebService(retrofit: Retrofit) : WebService {
        return retrofit.create(WebService::class.java)
    }



}