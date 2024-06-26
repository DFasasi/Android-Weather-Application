package com.example.weather_app.domain.weather

import java.util.ArrayList

data class WeatherInfo(
    //map int 0 is today, 1 is tomorrow, etc
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?,
    //val avgDataPerDay: ArrayList<Double>
)
