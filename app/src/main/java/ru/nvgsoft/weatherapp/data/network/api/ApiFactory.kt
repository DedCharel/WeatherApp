package ru.nvgsoft.weatherapp.data.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.nvgsoft.weatherapp.BuildConfig
import java.util.Locale

object ApiFactory {

    private const val KEY_PARAM = "key"
    private const val PARAM_LANG = "lang"
    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain  ->
            val originalRequest = chain.request()
            val newUrl = originalRequest
                .url()
                .newBuilder()
                .addQueryParameter(KEY_PARAM, BuildConfig.WEATHER_API_KEY)
                .addQueryParameter(PARAM_LANG, Locale.getDefault().language)
                .build()
            val newRequest = originalRequest.newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val apiService: ApiService = retrofit.create()
}