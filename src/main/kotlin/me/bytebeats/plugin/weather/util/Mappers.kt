package me.bytebeats.plugin.weather.util

import me.bytebeats.plugin.weather.data.simple.SimpleCity
import me.bytebeats.plugin.weather.resp.LocationResponse

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/4 20:32
 * @Version 1.0
 * @Description TO-DO
 */

fun simplifyCities(resp: LocationResponse): List<SimpleCity> {
    return resp.location.map { SimpleCity(it.name, it.adm2, it.adm1, it.country) }
}