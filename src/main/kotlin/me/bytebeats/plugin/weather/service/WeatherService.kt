package me.bytebeats.plugin.weather.service

import me.bytebeats.plugin.weather.resp.DailyWeatherResponse
import me.bytebeats.plugin.weather.resp.HourlyWeatherResponse
import me.bytebeats.plugin.weather.resp.RealTimeWeatherResponse
import me.bytebeats.plugin.weather.retrofit.RetrofitService
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/8/13 20:29
 * @Version 1.0
 * @Description TO-DO
 */

interface WeatherService {
    companion object {
        val service: WeatherService = RetrofitService.devService.create(WeatherService::class.java)
    }

    @GET("/v7/weather/now")
    fun realTimeWeather(@Query("location") location: String): RealTimeWeatherResponse

    @GET("/v7/weather/{range}")
    fun dayIntervalWeather(
        @Path("range") dayInterval: String,
        @Query("location") location: String
    ): DailyWeatherResponse

    @GET("/v7/weather/{range}")
    fun hourlyWeather(
        @Path("range") hourInterval: String,
        @Query("location") location: String
    ): HourlyWeatherResponse
}