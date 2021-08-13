package me.bytebeats.plugin.weather.service

import kotlinx.coroutines.Deferred
import me.bytebeats.plugin.weather.data.LocationWrapper
import retrofit2.Response

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/8/13 20:28
 * @Version 1.0
 * @Description TO-DO
 */

interface CityService {
    suspend fun queryCities(): Deferred<Response<LocationWrapper>>
}