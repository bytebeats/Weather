package me.bytebeats.plugin.weather.resp

import me.bytebeats.plugin.weather.data.City
import me.bytebeats.plugin.weather.data.DailyWeather
import me.bytebeats.plugin.weather.data.HourlyWeather
import me.bytebeats.plugin.weather.data.RealTimeWeather

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 21:15
 * @Version 1.0
 * @Description TO-DO
 */

data class TopCityResponse(val topCityList: List<City>) : BaseResponse()

data class LocationResponse(val location: List<City>) : BaseResponse()

/**
 * POI类型，可选择搜索某一类型的POI
 * scenic 景点
 * CSTA 潮流站点
 * TSTA 潮汐站点
 */
data class PoiResponse(val poi: List<City>) : BaseResponse()

data class RealTimeWeatherResponse(val now: RealTimeWeather) : BaseWeatherResponse()
data class DailyWeatherResponse(val daily: List<DailyWeather>) : BaseWeatherResponse()
data class HourlyWeatherResponse(val hourly: List<HourlyWeather>) : BaseWeatherResponse()