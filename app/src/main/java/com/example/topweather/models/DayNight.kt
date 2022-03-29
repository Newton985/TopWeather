package com.example.topweather.models

data class DayNight(
    val CloudCover: Int,
    val HasPrecipitation: Boolean,
    val HoursOfIce: Int,
    val HoursOfPrecipitation: Double,
    val HoursOfRain: Double,
    val HoursOfSnow: Int,
    val IceProbability: Int,
    val Icon: Int,
    val IconPhrase: String,
    val LongPhrase: String,
    val PrecipitationIntensity: String,
    val PrecipitationProbability: Int,
    val PrecipitationType: String,
    val Rain: Unit,
    val RainProbability: Int,
    val ShortPhrase: String,
    val SnowProbability: Int,
    val ThunderstormProbability: Int,
    val Wind: Wind,
)