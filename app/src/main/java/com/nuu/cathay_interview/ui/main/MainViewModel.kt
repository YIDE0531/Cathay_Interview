package com.nuu.cathay_interview.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nuu.cathay_interview.api.ApiManager
import com.nuu.cathay_interview.api.ApiService
import com.nuu.cathay_interview.model.DistrictItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val districtItemArray = MutableLiveData<DistrictItem?>()

    init {
        getDistrictItem()
    }

    private fun getDistrictItem() {
        val apiService = ApiManager.client.create(ApiService::class.java)
        apiService.index().enqueue(object : Callback<DistrictItem> {
            override fun onResponse(call: Call<DistrictItem>, response: Response<DistrictItem>) {
                val list = response.body()
                districtItemArray.postValue(list)
            }

            override fun onFailure(call: Call<DistrictItem>, t: Throwable) {

            }
        })
    }
}