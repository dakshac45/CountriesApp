package com.example.countries

import  retrofit2.Call
import retrofit2.http.GET

interface CountryService {
    @GET ("32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    fun getCountries(): Call<List<Country>>
}