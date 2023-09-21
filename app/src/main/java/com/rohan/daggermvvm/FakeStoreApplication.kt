package com.rohan.daggermvvm.di.com.rohan.daggermvvm

import android.app.Application
import com.rohan.daggermvvm.di.ApplicationComponent
import com.rohan.daggermvvm.di.DaggerApplicationComponent

class FakeStoreApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}