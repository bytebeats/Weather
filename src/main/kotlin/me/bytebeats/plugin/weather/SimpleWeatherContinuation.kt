package me.bytebeats.plugin.weather

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/4 20:26
 * @Version 1.0
 * @Description TO-DO
 */

abstract class SimpleWeatherContinuation<in T> : AbstractWeatherContinuation<T>() {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext
}