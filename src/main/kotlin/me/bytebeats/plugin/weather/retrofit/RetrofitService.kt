package me.bytebeats.plugin.weather.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL_GEOAPI = "https://geoapi.qweather.com"
    private const val BASE_URL_DEVAPI = "https://devapi.qweather.com"
    private const val BASE_URL_API = "https://api.qweather.com"
    private const val BASE_URL_DATAAPI = "https://datasetapi.qweather.com"

    private const val DEFAULT_TIMEOUT = 5L

    private fun createRetrofitService(baseUrl: String): Retrofit {
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor {
                println(it)
            }.setLevel(HttpLoggingInterceptor.Level.BASIC))
            .addInterceptor(ParameterInterceptor()).build()
        val builder =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
        return builder.build()
    }
}