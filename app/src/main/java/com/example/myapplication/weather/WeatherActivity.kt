package com.example.myapplication.weather


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.R

class WeatherDetailActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewCity = findViewById<TextView>(R.id.textViewCity)
        val textViewTemp = findViewById<TextView>(R.id.textViewTemp)
        val textViewCondition = findViewById<TextView>(R.id.textViewCondition)

        val city = intent.getStringExtra("CITY_NAME") ?: return
        viewModel.getWeather(city)

        viewModel.weatherData.observe(this, Observer { weather ->
            if (weather != null) {
                textViewName.text = "Location: ${weather.location.name}"
                textViewCity.text = "City: ${weather.location.name}, ${weather.location.country}"
                textViewTemp.text = "Temperature: ${weather.current.temp_c}°C"
                textViewCondition.text = "Condition: ${weather.current.condition.text}"
            } else {
                Log.e("WeatherDetailActivity", "Weather data is NULL")
            }
        })
    }
}