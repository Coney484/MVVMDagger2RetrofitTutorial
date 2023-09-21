package com.rohan.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rohan.daggermvvm.Products
import com.rohan.daggermvvm.Retrofit.WebService
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val api: WebService) {

    private val _products = MutableLiveData<List<Products>>()
    val products :LiveData<List<Products>> = _products

    suspend fun getProducts(){
        val result = api.getProducts()
        if(result.isSuccessful && result != null){
            _products.postValue(result.body())
        }
    }
}