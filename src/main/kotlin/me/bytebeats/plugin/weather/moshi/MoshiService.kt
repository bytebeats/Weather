package me.bytebeats.plugin.weather.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiService {
    val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}