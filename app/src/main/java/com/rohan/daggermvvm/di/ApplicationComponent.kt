package com.rohan.daggermvvm.di

import com.rohan.daggermvvm.MainActivity
import com.rohan.daggermvvm.di.com.rohan.daggermvvm.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}