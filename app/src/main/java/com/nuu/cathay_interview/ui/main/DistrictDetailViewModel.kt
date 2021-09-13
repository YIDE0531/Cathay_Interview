package com.nuu.cathay_interview.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nuu.cathay_interview.api.ApiManager
import com.nuu.cathay_interview.api.ApiService
import com.nuu.cathay_interview.model.PlantItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DistrictDetailViewModel : ViewModel() {
    val plantItemArray = MutableLiveData<PlantItem?>()

    fun getPlantItem(eName: String?) {
        val apiService = ApiManager.client.create(ApiService::class.java)
        val params: MutableMap<String, String> = HashMap()
        params["q"] = eName ?: ""
        apiService.getPlantApi(params).enqueue(object : Callback<PlantItem> {
            override fun onResponse(call: Call<PlantItem>, response: Response<PlantItem>) {
                val list = response.body()
                plantItemArray.postValue(list)
            }

            override fun onFailure(call: Call<PlantItem>, t: Throwable) {

            }
        })
    }
}