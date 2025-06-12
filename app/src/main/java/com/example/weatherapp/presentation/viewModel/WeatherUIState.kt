package com.example.weatherapp.presentation.viewModel

import com.example.weatherapp.R
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.utils.WeatherAppColors
import com.example.weatherapp.utils.WeatherAppDarkColors

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherData: Weather? = null,
    val weatherColor: WeatherAppColors = WeatherAppDarkColors,
    val weatherImage: Int = R.drawable.mainly_clear,
    val isDay: Boolean = true,
    val error: String? = null
)
