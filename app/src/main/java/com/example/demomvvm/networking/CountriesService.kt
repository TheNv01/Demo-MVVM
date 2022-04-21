package com.example.demomvvm.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://restcountries.com/v3.1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object CountriesService {
    val retrofitService: CountriesApi by lazy { retrofit.create(CountriesApi::class.java) }
}