package com.example.demomvvm.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.databinding.CountryItemBinding
import com.example.demomvvm.model.Country

class CountriesAdapter : androidx.recyclerview.widget.ListAdapter<Country, CountriesAdapter.CountriesViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name.common == newItem.name.common
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name.common == newItem.name.common
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesViewHolder {
        return CountriesViewHolder(
            CountryItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)

    }

    class CountriesViewHolder(private var binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country){
            binding.country = country
            binding.executePendingBindings()
        }

    }


}