package com.example.weather_app.data.remote

import com.squareup.moshi.Json
import org.jetbrains.annotations.NotNull

data class WeatherAvgDto(
//    @field:Json(name = "hourly")
//    @NotNull
//    val avgData: ArrayList<Double>,

    @field:Json(name = "hourly")
    val temperatureData: WeatherTempsDto
)
