package com.stu.testapptour.network.main.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.home.MainPageData
import com.stu.testapptour.network.ErrorResponse

data class MainPageResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: ErrorResponse?,
    @SerializedName("time")
    val time: String,
    @SerializedName("data")
    val data: MainPageDataResponse
) {
    fun toMainPageData() : MainPageData {
        if(success)
            return data.toMainPageData()
        else
            (error as ErrorResponse).throwNetworkException()
    }
}