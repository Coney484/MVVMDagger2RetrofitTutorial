package com.rohan.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.rohan.daggermvvm.di.com.rohan.daggermvvm.FakeStoreApplication
import com.rohan.daggermvvm.viewmodel.ProductViewModel
import com.rohan.daggermvvm.viewmodel.ProductViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

      private lateinit var viewModel: ProductViewModel

      @Inject
      lateinit var productViewModelFactory: ProductViewModelFactory

      private val textViewProduct : TextView
          get() = findViewById(R.id.tvProducts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as FakeStoreApplication).applicationComponent.inject(this)
        viewModel = ViewModelProvider(this,productViewModelFactory).get(ProductViewModel::class.java)

        viewModel.products.observe(this){
           textViewProduct.text =  it.joinToString { x-> x.title + "\n\n" }
        }
    }
}