package com.example.weather_app.domain.weather

import java.time.LocalDateTime
import java.util.ArrayList

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
