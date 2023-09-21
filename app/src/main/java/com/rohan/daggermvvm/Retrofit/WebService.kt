package com.rohan.daggermvvm.Retrofit

import com.rohan.daggermvvm.Products
import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}