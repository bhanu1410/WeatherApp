package com.example.myapplication.api

import com.example.myapplication.astronomy.AstronomyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

import com.example.myapplication.weather.WeatherResponse

interface WeatherApi {
    @GET("current.json")
    fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<WeatherResponse>

    @GET("astronomy.json")
    fun getAstronomy(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("dt") date: String
    ): Call<AstronomyResponse>
}