package com.example.weatherapp.data.dto.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyDto(
    @SerialName("apparent_temperature_max") val apparentTemperatureMax: List<Double>,
    @SerialName("apparent_temperature_min") val apparentTemperatureMin: List<Double>,
    @SerialName("rain_sum") val rainSum: List<Double>,
    @SerialName("temperature_2m_max") val temperatureMax: List<Double>,
    @SerialName("temperature_2m_min") val temperatureMin: List<Double>,
    @SerialName("time") val time: List<String>,
    @SerialName("uv_index_max") val uvIndexMax: List<Double>,
    @SerialName("weather_code") val weatherCode: List<Int>
)
