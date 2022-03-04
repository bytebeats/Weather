package me.bytebeats.plugin.weather

import kotlinx.coroutines.runBlocking
import me.bytebeats.plugin.weather.service.CityService

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 20:48
 * @Version 1.0
 * @Description TO-DO
 */

class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runBlocking {
               val resp = CityService.service.queryCities("余")
                CityService.service.topCities(5)
            }
        }
    }
}