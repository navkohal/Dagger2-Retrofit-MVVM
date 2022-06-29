package com.example.mydaggerdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydaggerdemo.adapters.RepositoryAdapter
import com.example.mydaggerdemo.model.RepositoriesDataClass
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {


    private lateinit var reposListAdapter: RepositoryAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()

        initViewModel()
    }

    fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this@MainActivity).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(this, object :Observer<RepositoriesDataClass>{
            override fun onChanged(t: RepositoriesDataClass?) {
                if(t != null){
                    reposListAdapter.setUpdateData(t.items)
                    reposListAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Some data issues.....", Toast.LENGTH_SHORT).show()
                }
            }
        })

         mainActivityViewModel.makeApiCall()


    }


    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        reposListAdapter = RepositoryAdapter()
        recyclerView.adapter = reposListAdapter
    }

}