package com.example.weatherapp.data.service

import com.example.weatherapp.data.dto.local.LocationData

interface LocationProvider {
    suspend fun getUserLocation(): LocationData?
}