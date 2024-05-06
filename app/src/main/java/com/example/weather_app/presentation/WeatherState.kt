package com.example.weather_app.presentation

import com.example.weather_app.domain.weather.WeatherAvg
import com.example.weather_app.domain.weather.WeatherInfo
//import java.util.ArrayList
import kotlin.collections.ArrayList

data class WeatherState(
    val isLoading: Boolean = false,
    val weatherInfo: WeatherInfo? = null,
    val error: String? = "",
    val avg: WeatherAvg? = WeatherAvg(ArrayList())
)
