package com.nuu.cathay_interview.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DistrictItem(
    @SerializedName("result") var result: DistrictItemResult?,
): Serializable

data class DistrictItemResult(
    @SerializedName("limit") var limit: Int?,
    @SerializedName("offset") var offset: Int?,
    @SerializedName("count") var count: Int?,
    @SerializedName("sort") var sort: String?,
    @SerializedName("results") var results: List<DistrictItemResults>?
): Serializable

data class DistrictItemResults(
    @SerializedName("E_Pic_URL") var ePicURL: String?,
    @SerializedName("E_Geo") var eGeo: String?,
    @SerializedName("E_Info") var eInfo: String?,
    @SerializedName("E_no") var eNo: String?,
    @SerializedName("E_Category") var eCategory: String?,
    @SerializedName("E_Name") var eName: String?,
    @SerializedName("E_Memo") var eMemo: String?,
    @SerializedName("_id") var eId: String?,
    @SerializedName("E_URL") var eUrl: String?,
): Serializable

