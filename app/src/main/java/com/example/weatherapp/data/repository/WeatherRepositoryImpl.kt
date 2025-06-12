package com.example.weatherapp.data.repository

import android.os.Build
import android.util.Log
import android.util.Log.e
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.dto.remote.WeatherResponseDto
import com.example.weatherapp.data.mapper.WeatherMapperImpl
import com.example.weatherapp.data.service.LocationProvider
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
    private val client: HttpClient,
    private val weatherMapper: WeatherMapperImpl,
    private val locationProvider: LocationProvider,
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun fetchWeather(): Weather {
        val userLocation =
            locationProvider.getUserLocation() ?: throw Exception("User location is null")

        return withContext(Dispatchers.IO) {
                val response: WeatherResponseDto =
                    client.get(BASE_URL) {
                        parameter("latitude", userLocation.latitude)
                        parameter("longitude", userLocation.longitude)
                        parameter("daily", DAILY)
                        parameter("hourly", HOURLY)
                        parameter("current", CURRENT)

                    }.body()
                Log.d("WeatherRepository", "$response")
                weatherMapper.mapToWeatherUiModel(response, userLocation.cityName)
        }
    }

    companion object {
        private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
        private const val DAILY =
            "weather_code,rain_sum,temperature_2m_max,temperature_2m_min,uv_index_max,apparent_temperature_max,apparent_temperature_min"
        private const val HOURLY =
            "temperature_2m,weather_code,relative_humidity_2m,wind_speed_10m,apparent_temperature,precipitation_probability"
        private const val CURRENT =
            "temperature_2m,weather_code,wind_speed_10m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,pressure_msl"

    }


}