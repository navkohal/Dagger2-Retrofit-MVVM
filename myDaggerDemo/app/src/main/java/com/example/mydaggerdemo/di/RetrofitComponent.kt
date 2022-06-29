package com.example.mydaggerdemo.di

import com.example.mydaggerdemo.MainActivityViewModel
import dagger.Component
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component
(modules = [RetorfitModule::class])
interface RetrofitComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}