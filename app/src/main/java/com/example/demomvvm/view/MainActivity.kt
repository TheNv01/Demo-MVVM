package com.example.demomvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.demomvvm.databinding.ActivityMainBinding
import com.example.demomvvm.viewmodel.CountriesViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: CountriesViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel

        binding.btnGetData.setOnClickListener{
            viewModel.getData()
        }
        binding.recyclerViewCountries.adapter = CountriesAdapter()
    }
}