package me.bytebeats.plugin.weather.service

import kotlinx.coroutines.Deferred
import me.bytebeats.plugin.weather.data.LocationWrapper
import retrofit2.Response
import retrofit2.http.GET

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/8/13 20:28
 * @Version 1.0
 * @Description CityService
 */

interface CityService {
    @GET("")
    fun queryCities(): Deferred<Response<LocationWrapper>>
}