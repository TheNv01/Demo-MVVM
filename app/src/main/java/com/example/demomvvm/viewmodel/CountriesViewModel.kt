package com.example.demomvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.demomvvm.database.CountryRoomDatabase
import com.example.demomvvm.model.Country
import com.example.demomvvm.networking.CountriesService
import com.example.demomvvm.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

enum class CountriesApiStatus { LOADING, DONE }

class CountriesViewModel(application: Application) : AndroidViewModel(application){

    private var _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _status = MutableLiveData<CountriesApiStatus>()
    val status: LiveData<CountriesApiStatus> = _status

    private val repository: CountryRepository


    init {
        val countryDAO = CountryRoomDatabase.CountryDatabaseBuilder.getInstance(application).countryDAO()
        repository = CountryRepository(countryDAO)
        _status.value = CountriesApiStatus.DONE

    }
    fun getData(){
        _status.value = CountriesApiStatus.LOADING
        viewModelScope.launch {
            CountriesService.retrofitService.getCountries().enqueue(object : retrofit2.Callback<List<Country>> {
                override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                    response.body()?.let {
                        _countries.value = it
                        insertData(it)
                    }
                    _status.value = CountriesApiStatus.DONE
                }

                override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                    _countries.value = repository.countryList
                    _status.value = CountriesApiStatus.DONE
                }

            })
        }
    }
     fun insertData(countries: List<Country>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(countries)
        }
    }

}