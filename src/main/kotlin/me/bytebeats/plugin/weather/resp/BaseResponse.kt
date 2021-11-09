package me.bytebeats.plugin.weather.resp

import me.bytebeats.plugin.weather.data.Refer

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 21:12
 * @Version 1.0
 * @Description TO-DO
 */

open class BaseResponse {
    var code: String = ""
    var refer: Refer? = null

    fun isSuccess(): Boolean = code == "200"
}