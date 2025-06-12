package com.example.weatherapp.domain.model

data class Weather(
    val city: String,
    val isDay: Boolean,
    val currentWeatherCode: Int,
    val temperature: Double,
    val weatherDescription: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val windSpeed: Double,
    val humidity: Int,
    val rainChance: Int,
    val uvIndex: Int,
    val pressure: Double,
    val feelsLike: Double,
    val hourlyForecast: List<HourlyWeather>,
    val weeklyForecast: List<DailyWeather>
)



