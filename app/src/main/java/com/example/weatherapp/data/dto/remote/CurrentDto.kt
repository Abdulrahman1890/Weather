package com.example.weatherapp.data.dto.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentDto(
    @SerialName("apparent_temperature") val apparentTemperature: Double,
    @SerialName("interval") val interval: Int,
    @SerialName("is_day") val isDay: Int,
    @SerialName("precipitation") val precipitation: Double,
    @SerialName("pressure_msl") val pressure: Double,
    @SerialName("rain") val rain: Double,
    @SerialName("relative_humidity_2m") val humidity: Int,
    @SerialName("temperature_2m") val temperature: Double,
    @SerialName("time") val time: String,
    @SerialName("showers") val showers: Double,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("wind_speed_10m") val windSpeed: Double
)
