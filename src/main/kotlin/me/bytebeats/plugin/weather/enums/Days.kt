package me.bytebeats.plugin.weather.enums

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 21:35
 * @Version 1.0
 * @Description TO-DO
 */

enum class Days(private val value: String) {
    //dev api or commercial api
    ThreeDay("3d"),
    SevenDay("7d"),

    //only for commercial api
    TenDay("10d"),
    FifteenDay("15d");
}