package com.example.countries

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CountryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        errorText = findViewById(R.id.errorText)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.fetchCountries()

        viewModel.countries.observe(this) {
            recyclerView.adapter = CountryAdapter(it)
        }

        viewModel.error.observe(this) {
            errorText.text = it
            errorText.visibility = TextView.VISIBLE
        }
    }
}