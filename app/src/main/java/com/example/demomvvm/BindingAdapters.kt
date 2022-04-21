package com.example.demomvvm

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.model.Country
import com.example.demomvvm.view.CountriesAdapter
import com.example.demomvvm.viewmodel.CountriesApiStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Country>?) {
    val adapter = recyclerView.adapter as CountriesAdapter
    adapter.submitList(data)
}

@BindingAdapter("countriesApiStatus")
fun bindStatus(progressBar: ProgressBar, status: CountriesApiStatus?) {
    if(status == CountriesApiStatus.DONE){
        progressBar.visibility = View.GONE
    }
    else{
        progressBar.visibility = View.VISIBLE
    }
}