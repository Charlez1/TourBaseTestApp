package com.stu.testapptour.network.blog.response.list

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.network.ErrorResponse

data class BlogListResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: ErrorResponse,
    @SerializedName("time")
    val time: String,
    @SerializedName("data")
    val data: List<BlogItemResponse>
) {
    fun toBlogList() : List<BlogItem> {
        if(success)
            return data.map { it.toBlogSummary() }
        else
            error.throwNetworkException()
    }
}


