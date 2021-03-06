package com.kekod.awesomeframework.api

import com.kekod.awesomeframework.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {
    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        private fun getRetrofit(): Retrofit {
            return INSTANCE ?: run {
                synchronized(this) {
                    Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BuildConfig.BASE_URL)
                        .build()
                }
            }
        }
    }
}