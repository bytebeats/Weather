package me.bytebeats.plugin.weather

import kotlin.coroutines.Continuation

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/4 20:20
 * @Version 1.0
 * @Description Continuation for Java call suspend functions
 */

abstract class AbstractWeatherContinuation<in T> : Continuation<T> {
    abstract fun resume(result: T)
    abstract fun resumeException(t: Throwable)
    override fun resumeWith(result: Result<T>) = result.fold(::resume, ::resumeException)
}