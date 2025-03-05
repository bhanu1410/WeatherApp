package com.example.myapplication.astronomy

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import java.util.*

class AstronomyActivity : AppCompatActivity() {

    private val astronomyViewModel: AstronomyViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy)

        val textViewCity = findViewById<TextView>(R.id.textViewCity)
        val textViewSunrise = findViewById<TextView>(R.id.textViewSunrise)
        val textViewSunset = findViewById<TextView>(R.id.textViewSunset)
        val textViewMoonrise = findViewById<TextView>(R.id.textViewMoonrise)
        val textViewMoonset = findViewById<TextView>(R.id.textViewMoonset)
        val textViewMoonPhase = findViewById<TextView>(R.id.textViewMoonPhase)

        val city = intent.getStringExtra("CITY_NAME")
        city?.let {
            astronomyViewModel.fetchAstronomy(city, Date().toString())
        }

        astronomyViewModel.astronomyData.observe(this,
            androidx.lifecycle.Observer { astronomyResponse ->
                astronomyResponse?.let {
                    textViewCity.text = "City: ${it.location.name}"
                    textViewSunrise.text = "Sunrise: ${it.astronomy.astro.sunrise}"
                    textViewSunset.text = "Sunset: ${it.astronomy.astro.sunset}"
                    textViewMoonrise.text = "Moonrise: ${it.astronomy.astro.moonrise}"
                    textViewMoonset.text = "Moonset: ${it.astronomy.astro.moonset}"
                    textViewMoonPhase.text = "Moon Phase: ${it.astronomy.astro.moon_phase}"
                }
            })
    }
}