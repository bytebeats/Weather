package me.bytebeats.plugin.weather.service

import me.bytebeats.plugin.weather.data.LocationWrapper
import me.bytebeats.plugin.weather.retrofit.RetrofitService
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/8/13 20:28
 * @Version 1.0
 * @Description CityService
 */

interface CityService {
    companion object {
        val service: CityService = RetrofitService.geoService.create(CityService::class.java)
    }

    @GET("/v2/city/lookup")
    suspend fun queryCities(@Query("location") location: String): LocationWrapper
}