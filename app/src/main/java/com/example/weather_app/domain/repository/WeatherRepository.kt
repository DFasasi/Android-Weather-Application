package com.example.weather_app.domain.repository

import com.example.weather_app.domain.util.Resource
import com.example.weather_app.domain.weather.WeatherAvg
import com.example.weather_app.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
    suspend fun avg(lat: Double, long: Double): Resource<WeatherAvg>
}