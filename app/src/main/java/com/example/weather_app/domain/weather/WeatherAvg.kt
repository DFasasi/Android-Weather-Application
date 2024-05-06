package com.example.weather_app.domain.weather

import java.util.ArrayList

data class WeatherAvg(
    //map int 0 is today, 1 is tomorrow, etc
    val avgData: ArrayList<Double>?
    //val avgDataPerDay: ArrayList<Double>
)
