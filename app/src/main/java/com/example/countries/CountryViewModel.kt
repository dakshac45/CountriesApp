package com.example.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val error = MutableLiveData<String>()

    fun fetchCountries() {
        RetrofitClient.service.getCountries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    countries.value = response.body()
                } else {
                    error.value = "Response not successful"
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}
