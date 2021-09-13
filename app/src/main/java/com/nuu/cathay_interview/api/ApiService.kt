package com.nuu.cathay_interview.api
import com.nuu.cathay_interview.model.DistrictItem
import com.nuu.cathay_interview.model.PlantItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    fun index(): Call<DistrictItem>

    @GET("/api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14?scope=resourceAquire")
    fun getPlantApi(@QueryMap params: Map<String, String>): Call<PlantItem>
}