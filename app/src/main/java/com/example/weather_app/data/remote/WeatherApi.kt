package com.example.weather_app.data.remote

import com.example.weather_app.domain.weather.WeatherAvg
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl&temperature_unit=fahrenheit&wind_speed_unit=mph")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherDto

    //for avg temp
    @GET("v1/forecast?hourly=temperature_2m&temperature_unit=fahrenheit")
    suspend fun avg(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): WeatherAvgDto

    //data transfer object
}