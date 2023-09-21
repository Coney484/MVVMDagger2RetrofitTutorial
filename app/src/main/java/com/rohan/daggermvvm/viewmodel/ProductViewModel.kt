package com.rohan.daggermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohan.daggermvvm.Products
import com.rohan.daggermvvm.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductsRepository) : ViewModel() {

    val products: LiveData<List<Products>>
        get() = repository.products

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts()
        }
    }
}
