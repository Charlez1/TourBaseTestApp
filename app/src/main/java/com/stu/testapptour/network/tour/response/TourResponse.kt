package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourItem
import com.stu.testapptour.network.ErrorResponse

data class TourResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("error") val error: ErrorResponse,
    @SerializedName("time") val time: String,
    @SerializedName("data") val data: List<TourItemResponse>
) {
    fun toTourList() : List<TourItem> {
        if(success)
            return data.map { it.toTourData() }
        else
            error.throwNetworkException()
    }
}
