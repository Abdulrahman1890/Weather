package com.example.weatherapp.data.dto.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyUnitsDto(
    @SerialName("apparent_temperature_max") val apparentTemperatureMax: String,
    @SerialName("apparent_temperature_min") val apparentTemperatureMin: String,
    @SerialName("rain_sum") val rainSum: String,
    @SerialName("temperature_2m_max") val temperatureMax: String,
    @SerialName("temperature_2m_min") val temperatureMin: String,
    @SerialName("time") val time: String,
    @SerialName("uv_index_max") val uvIndexMax: String,
    @SerialName("weather_code") val weatherCode: String
)
