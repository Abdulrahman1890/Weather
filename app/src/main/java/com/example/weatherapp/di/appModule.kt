package com.example.weatherapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.weatherapp.data.mapper.WeatherMapperImpl
import com.example.weatherapp.data.repository.LocationProviderImpl
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.data.service.LocationProvider
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.usecases.WeatherUseCase
import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
    single<LocationProvider> { LocationProviderImpl(androidContext()) }

    single { WeatherMapperImpl() }

    single<WeatherRepository> { WeatherRepositoryImpl(get(), get(), get()) }

    single { WeatherUseCase(get()) }

    viewModel {
        WeatherViewModel(get())
    }

}