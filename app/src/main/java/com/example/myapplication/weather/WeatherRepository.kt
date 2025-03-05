package com.example.myapplication.weather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {
    private val apiKey = "187d898146f543a3b4c112505210708"
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> = _weatherData

    fun fetchWeather(city: String) {

        val call = RetrofitInstance.api.getWeather(apiKey, city)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    _weatherData.postValue(response.body())
                } else {
                    Log.e("WeatherRepository", "Error: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("WeatherRepository", "API call failed", t)
            }
        })
    }
}