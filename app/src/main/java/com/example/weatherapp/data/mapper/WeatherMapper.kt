package com.example.weatherapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.dto.remote.WeatherResponseDto
import com.example.weatherapp.domain.model.DailyWeather
import com.example.weatherapp.domain.model.HourlyWeather
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.utils.WeatherCodeResource
import java.time.LocalDate
import java.time.LocalDateTime

class WeatherMapperImpl {
    @RequiresApi(Build.VERSION_CODES.O)
    fun mapToWeatherUiModel(
        response: WeatherResponseDto, cityName: String
    ): Weather {
        return Weather(
            city = cityName,
            isDay = response.current.isDay == 1,
            currentWeatherCode = response.current.weatherCode,
            temperature = response.current.temperature,
            weatherDescription = WeatherCodeResource.getWeatherDescription(response.current.weatherCode),
            temperatureMax = response.daily.temperatureMax[FIRST_INDEX],
            temperatureMin = response.daily.temperatureMin[FIRST_INDEX],
            windSpeed = response.current.windSpeed,
            humidity = response.current.humidity,
            rainChance = response.hourly.precipitationProbability[FIRST_INDEX],
            uvIndex = response.daily.uvIndexMax[FIRST_INDEX].toInt(),
            pressure = response.current.pressure,
            feelsLike = response.current.apparentTemperature,
            hourlyForecast = response.hourly.time.mapIndexed { index, time ->
                HourlyWeather(
                    time = time,
                    temperature = response.hourly.temperature[index],
                    weatherCode = response.hourly.weatherCode[index]
                )
            }.filter { hour ->
                val hourDateTime = LocalDateTime.parse(hour.time)
                hourDateTime.hour >= LocalDateTime.now().hour && hourDateTime.toLocalDate() == LocalDate.now()
            }.take(HOURS),
            weeklyForecast = response.daily.time.mapIndexed { index, day ->
                DailyWeather(
                    day = day,
                    temperatureMax = response.daily.temperatureMax[index],
                    temperatureMin = response.daily.temperatureMin[index],
                    weatherCode = response.daily.weatherCode[index]
                )
            })
    }
    companion object {
        private const val HOURS = 23
        private const val FIRST_INDEX = 0
    }
}

