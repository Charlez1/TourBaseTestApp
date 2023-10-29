package com.stu.testapptour.network.blog.response.info

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.network.ErrorResponse

data class BlogInfoResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: ErrorResponse,
    @SerializedName("time")
    val time: String,
    @SerializedName("data")
    val data: BlogInfoDataResponse
) {
    fun toBlogInfo(): BlogInfo {
        if(success) {
            return data.toBlogInfo()
        } else
            error.throwNetworkException()
    }
}
