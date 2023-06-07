package com.example.danp_lab3.Data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import com.example.danp_lab3.Data.Country
import com.example.danp_lab3.Data.CountryDao

class Repository(private val countryDao: CountryDao) {

    val allCountry : LiveData<List<Country>> = countryDao.getAllCountry()
    val countriesPaging : PagingSource<Int, Country> = countryDao.getAllCountryPaging()

    suspend fun addCountry(country: Country ){
        countryDao.insertCountry(country)
    }


}