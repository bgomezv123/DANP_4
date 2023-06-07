package com.example.danp_lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.danp_lab4.Data.CountryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        val adapterCountry = AdapterCountryPaging()
        val rv = findViewById<RecyclerView>(R.id.rv_activityMain_browse)
        rv.adapter = adapterCountry

        GlobalScope.launch(Dispatchers.IO){
            viewModel.pagingSource().collect(){
                adapterCountry.submitData(it)
            }
        }
    }
}