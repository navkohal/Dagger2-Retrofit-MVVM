package com.example.mydaggerdemo.di

import com.example.mydaggerdemo.model.RepositoriesDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetorfitServiceInterface {

    @GET("repositories")
    fun getRepositoriesApi(@Query("q")query: String): Call<RepositoriesDataClass>?
}