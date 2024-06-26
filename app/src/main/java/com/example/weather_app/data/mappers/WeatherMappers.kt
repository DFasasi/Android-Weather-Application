package com.example.weather_app.data.mappers

import com.example.weather_app.data.remote.WeatherAvgDto
import com.example.weather_app.data.remote.WeatherDataDto
import com.example.weather_app.data.remote.WeatherDto
import com.example.weather_app.data.remote.WeatherTempsDto
import com.example.weather_app.data.remote.avg
import com.example.weather_app.domain.weather.WeatherAvg
import com.example.weather_app.domain.weather.WeatherData
import com.example.weather_app.domain.weather.WeatherInfo
import com.example.weather_app.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
//import java.util.ArrayList
import kotlin.collections.ArrayList

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherTempsDto.createTempsArr(): ArrayList<Double>{
    return ArrayList(temperatures)
}


fun WeatherAvgDto.toAvg(): WeatherAvg {
    var temperatures = temperatureData.createTempsArr()
    var tempAverages = ArrayList<Double>()
    var i = 0
    var runningTot = 0.0
    while(i < 168) {
        runningTot+= temperatures[i]
        if(i%23 == 0 && i > 0){
            tempAverages.add(runningTot/24)
            runningTot = 0.0
        }
        i++
    }
    return WeatherAvg(avgData = tempAverages)
}

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {

    /*var tempAverages = ArrayList<Double>()
    var i = 0
    var runningTot = 0.0
    while(i < 168) {
        runningTot+=temperatures[i]
        if(i%23 == 0 && i > 0){
            tempAverages.add(runningTot/24)
            runningTot = 0.0
        }
        i++
    }*/

    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / (24*7)
    }.mapValues { it ->
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}