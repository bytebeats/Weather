package me.bytebeats.plugin.weather.retrofit

import me.bytebeats.plugin.weather.util.APP_KEY
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
        val original = chain.request()
        val originalUrl = original.url
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("key", APP_KEY)
            .build()
        val requestBuilder = original.newBuilder().url(newUrl)
        return chain.proceed(requestBuilder.build())
    }
}