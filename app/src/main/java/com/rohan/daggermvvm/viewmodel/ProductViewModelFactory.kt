package com.rohan.daggermvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rohan.daggermvvm.repository.ProductsRepository
import javax.inject.Inject

class ProductViewModelFactory @Inject constructor(private val repository: ProductsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}