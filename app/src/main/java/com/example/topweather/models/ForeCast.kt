package com.example.topweather.models

data class ForeCast(
    val Date: String,
    val Day: DayNight,
    val EpochDate: Long,
    val Link: String,
    val MobileLink: String,
    val Night: DayNight,
    val Sources: List<String>,
    val Temperature: ForecastTemperature
)