package com.example.myapplication.astronomy

data class AstronomyResponse(
    val location: Location,
    val astronomy: Astronomy
)

data class Astronomy(
    val astro: Astro
)

data class Astro(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moon_phase: String
)

data class Location(
    val name: String,
    val country: String
)