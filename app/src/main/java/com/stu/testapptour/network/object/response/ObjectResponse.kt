package com.stu.testapptour.network.`object`.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.`object`.ObjectItem
import com.stu.testapptour.network.ErrorResponse

data class ObjectResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("error") val error: ErrorResponse,
    @SerializedName("time") val time: String,
    @SerializedName("data") val data: List<ObjectItemResponse>
) {
    fun toObjectList() : List<ObjectItem> {
        if(success)
            return data.map { it.toObjectItem() }
        else
            error.throwNetworkException()
    }
}
