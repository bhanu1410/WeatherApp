package com.example.myapplication.astronomy

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AstronomyRepository {
    private val apiKey = "187d898146f543a3b4c112505210708"
    private val _astronomyData = MutableLiveData<AstronomyResponse>()
    val astronomyData: LiveData<AstronomyResponse> = _astronomyData

    fun getAstronomy(city: String, date: String) {
        val call = RetrofitInstance.api.getAstronomy(apiKey, city, date)

        call.enqueue(object : Callback<AstronomyResponse> {
            override fun onResponse(call: Call<AstronomyResponse>, response: Response<AstronomyResponse>) {
                if (response.isSuccessful) {
                    _astronomyData.postValue(response.body())
                } else {
                    Log.e("AstronomyRepository", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AstronomyResponse>, t: Throwable) {
                Log.e("AstronomyRepository", "API call failed", t)
            }
        })
    }
}