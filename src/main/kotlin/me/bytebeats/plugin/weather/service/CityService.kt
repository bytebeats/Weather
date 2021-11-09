package me.bytebeats.plugin.weather.service

import me.bytebeats.plugin.weather.enums.POI
import me.bytebeats.plugin.weather.resp.LocationResponse
import me.bytebeats.plugin.weather.resp.PoiResponse
import me.bytebeats.plugin.weather.resp.TopCityResponse
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
    suspend fun queryCities(@Query("location") location: String): LocationResponse

    @GET("/v2/city/top")
    suspend fun topCities(@Query("number") topN: Int, @Query("range") country: String = "cn"): TopCityResponse

    @GET("/v2/poi/lookup")
    suspend fun poi(@Query("location") location: String, @Query("type") type: POI): PoiResponse
}