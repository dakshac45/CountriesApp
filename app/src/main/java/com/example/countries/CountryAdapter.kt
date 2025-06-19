package com.example.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countries: List<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameRegion: TextView = itemView.findViewById(R.id.name_region)
        val code: TextView = itemView.findViewById(R.id.code)
        val capital: TextView = itemView.findViewById(R.id.capital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.nameRegion.text = "${country.name}, ${country.region}"
        holder.code.text = country.code
        holder.capital.text = country.capital
    }

    override fun getItemCount() = countries.size
}
