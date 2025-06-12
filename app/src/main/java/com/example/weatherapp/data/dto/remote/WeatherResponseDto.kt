package com.example.weatherapp.data.dto.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDto(
    @SerialName("current") val current: CurrentDto,
    @SerialName("current_units") val currentUnits: CurrentUnitsDto,
    @SerialName("daily") val daily: DailyDto,
    @SerialName("daily_units") val dailyUnits: DailyUnitsDto,
    @SerialName("elevation") val elevation: Double,
    @SerialName("generationtime_ms") val generationTime: Double,
    @SerialName("hourly") val hourly: HourlyDto,
    @SerialName("hourly_units") val hourlyUnits: HourlyUnitsDto,
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double,
    @SerialName("timezone") val timezone: String,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int
)