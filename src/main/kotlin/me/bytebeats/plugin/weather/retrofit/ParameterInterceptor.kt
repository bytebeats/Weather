package me.bytebeats.plugin.weather.retrofit

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/8/13 21:23
 * @Version 1.0
 * @Description TO-DO
 */

class ParameterInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}