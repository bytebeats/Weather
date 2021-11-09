package me.bytebeats.plugin.weather.data

data class HourlyWeather(
    val fxTime: String,
    val temp: String,
    val icon: String,
    val text: String,
    val wind360: String,
    val windDir: String,
    val windScale: String,
    val windSpeed: String,
    val humidity: String,
    val pop: String,
    val precip: String,
    val pressure: String,
    val cloud: String,
    val dew: String,
)
