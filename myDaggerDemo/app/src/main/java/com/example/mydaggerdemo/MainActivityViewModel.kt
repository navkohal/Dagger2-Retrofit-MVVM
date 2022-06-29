package com.example.mydaggerdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mydaggerdemo.di.RetorfitServiceInterface
import com.example.mydaggerdemo.model.RepositoriesDataClass
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.PrivateKey
import javax.inject.Inject


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mService : RetorfitServiceInterface

    var liveDataList: MutableLiveData<RepositoriesDataClass>

    init {
        //instantiate application class here
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<RepositoriesDataClass>{
        return liveDataList
    }



    fun makeApiCall(){
        val call: Call<RepositoriesDataClass>? = mService.getRepositoriesApi("alt")
        call?.enqueue(object : Callback<RepositoriesDataClass>{
            override fun onResponse(
                call: Call<RepositoriesDataClass>,
                response: Response<RepositoriesDataClass>
            ) {
                if(response.isSuccessful){
                    liveDataList.postValue(response.body())
                }else{
                    liveDataList.postValue(null)
                }
            }

            override fun onFailure(call: Call<RepositoriesDataClass>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}