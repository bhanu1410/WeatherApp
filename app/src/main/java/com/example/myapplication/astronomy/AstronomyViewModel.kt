package com.example.myapplication.astronomy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class AstronomyViewModel : ViewModel() {
    private val repository = AstronomyRepository()
    val astronomyData: LiveData<AstronomyResponse> = repository.astronomyData

    fun fetchAstronomy(city: String, date: String) {
        repository.getAstronomy(city, date)
    }
}