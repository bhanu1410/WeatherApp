package com.example.myapplication.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()
    val weatherData: LiveData<WeatherResponse> = repository.weatherData

    fun getWeather(city: String) {
        repository.fetchWeather(city)
    }
}