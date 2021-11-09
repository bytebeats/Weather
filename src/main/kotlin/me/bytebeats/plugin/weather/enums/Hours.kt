package me.bytebeats.plugin.weather.enums

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2021/11/9 21:35
 * @Version 1.0
 * @Description TO-DO
 */

enum class Hours(private val value: String) {
    //dev api or commercial api
    TwentyFourDay("24h"),
    SeventyFourDay("72d"),

    //only for commercial api
    OneHundredSixtyEightDay("168d");
}