package com.example.weatherapp.domain.usecases

import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherUseCase (
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(): Weather {
        return repository.fetchWeather()
    }
}