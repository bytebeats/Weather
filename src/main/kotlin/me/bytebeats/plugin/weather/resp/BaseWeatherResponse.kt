package me.bytebeats.plugin.weather.resp

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 21:29
 * @Version 1.0
 * @Description TO-DO
 */

open class BaseWeatherResponse : BaseResponse() {
    var updateTime: String = ""
    var fxLink: String? = null
}