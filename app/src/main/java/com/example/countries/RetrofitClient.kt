package com.example.countries

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/peymano-wmt/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: CountryService = retrofit.create(CountryService::class.java)
}