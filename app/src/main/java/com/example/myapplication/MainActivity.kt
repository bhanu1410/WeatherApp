package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.astronomy.AstronomyActivity
import com.example.myapplication.weather.WeatherDetailActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCity = findViewById<EditText>(R.id.editCountry)
        val buttonSearchWeather = findViewById<Button>(R.id.buttonSearchWeather)
        val buttonSearchAstronomy = findViewById<Button>(R.id.buttonSearchAstronomy)

        buttonSearchWeather.setOnClickListener {
            val city = editTextCity.text.toString()
            if (city.isNotEmpty()) {
                val intent = Intent(this, WeatherDetailActivity::class.java)
                intent.putExtra("CITY_NAME", city)
                startActivity(intent)
            }
        }

        buttonSearchAstronomy.setOnClickListener {
            val city = editTextCity.text.toString()
            if (city.isNotEmpty()) {
                val intent = Intent(this, AstronomyActivity::class.java)
                intent.putExtra("CITY_NAME", city)
                startActivity(intent)
            }
        }
    }
}