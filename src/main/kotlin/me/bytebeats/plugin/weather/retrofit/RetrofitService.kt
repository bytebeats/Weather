package me.bytebeats.plugin.weather.retrofit

import me.bytebeats.plugin.weather.moshi.MoshiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitService {
    private const val BASE_URL_GEOAPI = "https://geoapi.qweather.com"
    private const val BASE_URL_DEVAPI = "https://devapi.qweather.com"
    private const val BASE_URL_API = "https://api.qweather.com"
    private const val BASE_URL_DATAAPI = "https://datasetapi.qweather.com"

    private const val DEFAULT_TIMEOUT = 5L

    private fun createRetrofitService(baseUrl: String): Retrofit {
        val client = OkHttpClient.Builder()
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor {
                println(it)
            }.setLevel(HttpLoggingInterceptor.Level.BASIC))
            .addInterceptor(ParameterInterceptor())
            .build()
        val builder =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(MoshiService.moshi))
        return builder.build()
    }

    val geoService: Retrofit = createRetrofitService(BASE_URL_GEOAPI)
    val devService: Retrofit = createRetrofitService(BASE_URL_DEVAPI)
    val apiService: Retrofit = createRetrofitService(BASE_URL_API)
    val dataService: Retrofit = createRetrofitService(BASE_URL_DATAAPI)
}