package com.example.weatherapp.utils

import com.example.weatherapp.R

object WeatherCodeResource {

    const val CODE_0 = 0
    const val CODE_1 = 1
    const val CODE_2 = 2
    const val CODE_3 = 3
    const val CODE_45 = 45
    const val CODE_48 = 48
    const val CODE_51 = 51
    const val CODE_53 = 53
    const val CODE_55 = 55
    const val CODE_56 = 56
    const val CODE_57 = 57
    const val CODE_61 = 61
    const val CODE_63 = 63
    const val CODE_65 = 65
    const val CODE_66 = 66
    const val CODE_67 = 67
    const val CODE_71 = 71
    const val CODE_73 = 73
    const val CODE_75 = 75
    const val CODE_77 = 77
    const val CODE_80 = 80
    const val CODE_81 = 81
    const val CODE_82 = 82
    const val CODE_85 = 85
    const val CODE_86 = 86
    const val CODE_95 = 95
    const val CODE_96 = 96
    const val CODE_99 = 99

    fun getWeatherDescription(weatherCode: Int): String {
        return when (weatherCode) {
            CODE_0 -> "Clear Sky"
            CODE_1 -> "Mainly Clear"
            CODE_2 -> "Partly Cloudy"
            CODE_3 -> "Overcast"
            CODE_45, CODE_48 -> "Foggy"
            CODE_51, CODE_53, CODE_55 -> "Drizzle"
            CODE_61, CODE_63, CODE_65 -> "Rainy"
            CODE_71, CODE_73, CODE_75 -> "Snowy"
            CODE_95 -> "Thunderstorm"
            else -> "Unknown Weather"
        }
    }


    fun getWeatherImage(weatherCode: Int, isDay: Boolean): Int {
        return when (weatherCode) {
            CODE_0 -> if (isDay) R.drawable.clear_sky_1 else R.drawable.clear_sky
            CODE_1 -> if (isDay) R.drawable.mainly_clear_1 else R.drawable.mainly_clear
            CODE_2 -> if (isDay) R.drawable.partly_cloudy_1 else R.drawable.partly_cloudy
            CODE_3 -> if (isDay) R.drawable.overcast_1 else R.drawable.overcast
            CODE_45 -> if (isDay) R.drawable.fog_1 else R.drawable.fog
            CODE_48 -> if (isDay) R.drawable.depositing_rime_fog_1 else R.drawable.depositing_rime_fog
            CODE_51 -> if (isDay) R.drawable.drizzle_light_1 else R.drawable.drizzle_light
            CODE_53 -> if (isDay) R.drawable.drizzle_moderate_1 else R.drawable.drizzle_moderate
            CODE_55 -> if (isDay) R.drawable.drizzle_intensity_1 else R.drawable.drizzle_intensity
            CODE_56 -> if (isDay) R.drawable.freezing_drizzle_light_1 else R.drawable.freezing_drizzle_light_1
            CODE_57 -> if (isDay) R.drawable.freezing_drizzle_intensity_1 else R.drawable.freezing_drizzle_intensity
            CODE_61 -> if (isDay) R.drawable.rain_slight_1 else R.drawable.rain_slight
            CODE_63 -> if (isDay) R.drawable.rain_moderate_1 else R.drawable.rain_moderate
            CODE_65 -> if (isDay) R.drawable.rain_intensity_1 else R.drawable.rain_intensity
            CODE_66 -> if (isDay) R.drawable.freezing_light else R.drawable.freezing_loght
            CODE_67 -> if (isDay) R.drawable.freezing_heavy_1 else R.drawable.freezing_heavy
            CODE_71 -> if (isDay) R.drawable.snow_fall_light_1 else R.drawable.snow_fall_light
            CODE_73 -> if (isDay) R.drawable.snow_fall_moderate_1 else R.drawable.snow_fall_moderate
            CODE_75 -> if (isDay) R.drawable.snow_fall_intensity_1 else R.drawable.snow_fall_intensity
            CODE_77 -> if (isDay) R.drawable.snow_grains_1 else R.drawable.snow_grains
            CODE_80 -> if (isDay) R.drawable.rain_shower_slight_1 else R.drawable.rain_shower_slight
            CODE_81 -> if (isDay) R.drawable.rain_shower_moderate_1 else R.drawable.rain_shower_moderate
            CODE_82 -> if (isDay) R.drawable.rain_shower_violent_1 else R.drawable.rain_shower_violent_1
            CODE_85 -> if (isDay) R.drawable.snow_shower_slight_1 else R.drawable.snow_shower_slight
            CODE_86 -> if (isDay) R.drawable.snow_shower_heavy_1 else R.drawable.snow_shower_heavy
            CODE_95 -> if (isDay) R.drawable.thunderstrom_slight_or_moderate_1 else R.drawable.thunderstrom_slight_or_moderate
            CODE_96 -> if (isDay) R.drawable.thunderstrom_with_slight_hail_1 else R.drawable.thunderstrom_with_slight_hail
            CODE_99 -> if (isDay) R.drawable.thunderstrom_with_heavy_hail_1 else R.drawable.thunderstrom_with_heavy_hail
            else -> R.drawable.mainly_clear_1
        }
    }
}

