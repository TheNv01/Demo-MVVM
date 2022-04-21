package com.example.demomvvm.networking

import com.example.demomvvm.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    fun getCountries(): Call<List<Country>>
}