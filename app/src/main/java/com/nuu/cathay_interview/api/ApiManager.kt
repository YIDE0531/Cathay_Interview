package com.nuu.cathay_interview.api

import com.nuu.cathay_interview.constant.AppConstant
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class ApiManager private constructor() {

    companion object {
        private val okHttpClient = OkHttpClient()
        val client by lazy { invoke(AppConstant.baseUrl) }
        val client2 by lazy { invoke(AppConstant.baseUrl2) }

        operator fun invoke(baseUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
    }
}