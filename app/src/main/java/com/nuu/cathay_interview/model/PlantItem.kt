package com.nuu.cathay_interview.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlantItem (
    @SerializedName("result") var result: PlantItemResult?,
): Serializable

data class PlantItemResult(
    @SerializedName("limit") var limit: Int?,
    @SerializedName("offset") var offset: Int?,
    @SerializedName("count") var count: Int?,
    @SerializedName("sort") var sort: String?,
    @SerializedName("results") var results: List<PlantItemResults>?
): Serializable

data class PlantItemResults(
    @SerializedName("F_Name_Latin") var fNameLatin: String?,
    @SerializedName("F_pdf02_ALT") var fPdf02Alt: String?,
    @SerializedName("F_Location") var fLocation: String?,
    @SerializedName("F_pdf01_ALT") var fPdf01Alt: String?,
    @SerializedName("F_Summary") var fSummary: String?,
    @SerializedName("F_Pic01_URL") var fPic01Url: String?,
    @SerializedName("F_pdf02_URL") var fPdf02Url: String?,
    @SerializedName("F_Pic02_URL") var fPic02Url: String?,
    @SerializedName("\uFEFFF_Name_Ch") var fNameCh: String?,    //api參數格式
    @SerializedName("F_Keywords") var fKeywords: String?,
    @SerializedName("F_Code") var fCode: String?,
    @SerializedName("F_Geo") var fGeo: String?,
    @SerializedName("F_Pic03_URL") var fPic03Url: String?,
    @SerializedName("F_Voice01_ALT") var fVoice01Alt: String?,
    @SerializedName("F_AlsoKnown") var fAlsoKnown: String?,
    @SerializedName("F_Voice02_ALT") var fVoice02Alt: String?,
    @SerializedName("F_Pic04_ALT") var ePic04Alt: String?,
    @SerializedName("F_Name_En") var fNameEn: String?,
    @SerializedName("F_Brief") var fBrief: String?,
    @SerializedName("F_Pic04_URL") var fPic04Url: String?,
    @SerializedName("F_Voice01_URL") var fVoice01Url: String?,
    @SerializedName("F_Feature") var fFeature: String?,
    @SerializedName("F_Pic02_ALT") var fPic02Alt: String?,
    @SerializedName("F_Family") var fFamily: String?,
    @SerializedName("F_Voice03_ALT") var fVoice03Alt: String?,
    @SerializedName("F_Voice02_URL") var fVoice02Url: String?,
    @SerializedName("F_Pic03_ALT") var fPic03Alt: String?,
    @SerializedName("F_Pic01_ALT") var fPic01Alt: String?,
    @SerializedName("F_CID") var fCid: String?,
    @SerializedName("F_pdf01_URL") var fPdf01Url: String?,
    @SerializedName("F_Vedio_URL") var fVedioUrl: String?,
    @SerializedName("F_Genus") var fGenus: String?,
    @SerializedName("F_Function＆Application") var fFunctionAndApplication: String?,
    @SerializedName("F_Voice03_URL") var fVoice03Url: String?,
    @SerializedName("F_Update") var fUpdate: String?,
    @SerializedName("_id") var plantId: Int?,
): Serializable