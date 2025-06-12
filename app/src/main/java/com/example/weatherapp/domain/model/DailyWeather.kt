package com.example.weatherapp.domain.model

data class DailyWeather(
    val day: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val weatherCode: Int
)