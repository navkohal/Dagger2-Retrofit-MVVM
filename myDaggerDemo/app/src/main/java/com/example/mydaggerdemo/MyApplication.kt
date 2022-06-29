package com.example.mydaggerdemo

import android.app.Application
import com.example.mydaggerdemo.di.DaggerRetrofitComponent
import com.example.mydaggerdemo.di.RetorfitModule
import com.example.mydaggerdemo.di.RetrofitComponent

class MyApplication : Application() {

    lateinit var retrofitComponent : RetrofitComponent

    override fun onCreate() {
        super.onCreate()

        retrofitComponent = DaggerRetrofitComponent.builder()
            .retorfitModule(RetorfitModule())
            .build()
    }

    fun getRetroComponent(): RetrofitComponent {
        return retrofitComponent
    }

}