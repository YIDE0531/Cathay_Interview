package com.nuu.cathay_interview.api

import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class ApiManager private constructor() {
    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://data.taipei")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = ApiManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}