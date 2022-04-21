package com.example.demomvvm.repository

import com.example.demomvvm.database.CountryDAO
import com.example.demomvvm.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CountryRepository(private val countryDAO: CountryDAO) {

    lateinit var countryList: List<Country>

    init {
        GlobalScope.launch(Dispatchers.IO) {
            countryList = countryDAO.getAllData()
        }
    }

    suspend fun insertData(countries: List<Country>) {
        countryDAO.insertAllData(countries)
    }

}