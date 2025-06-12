package com.example.weatherapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.usecases.WeatherUseCase
import com.example.weatherapp.utils.WeatherAppDarkColors
import com.example.weatherapp.utils.WeatherAppDayColors
import com.example.weatherapp.utils.WeatherCodeResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: WeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState>
        get() = _state.asStateFlow()

    init {
        fetchWeather()
    }

    fun fetchWeather() {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch(Dispatchers.IO) {
            val weatherData = getWeatherUseCase()
            val isDay = weatherData.isDay
            val weatherColor = if (isDay) WeatherAppDayColors else WeatherAppDarkColors
            val weatherImage = WeatherCodeResource
                .getWeatherImage(weatherData.currentWeatherCode, isDay)

            _state.update {
                it.copy(
                    weatherData = weatherData,
                    weatherColor = weatherColor,
                    weatherImage = weatherImage,
                    isDay = isDay,
                    isLoading = false
                )
            }
        }
    }
}
