package com.example.weather_app.data.remote

import com.squareup.moshi.Json

data class WeatherTempsDto(
//    val time: List<String>,
    @field:Json(name = "temperature_2m")
    val temperatures: List<Double>,
)
