package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourDate

data class TourDateResponse(
    @SerializedName("typeDate") val typeDate: String,
    @SerializedName("date") val date: String
) {
    fun toTourDate(): TourDate {
        return TourDate(
            typeDate = typeDate,
            date = date
        )
    }
}
