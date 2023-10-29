package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourDuration

data class TourDurationResponse(
    @SerializedName("day") val day: Int,
    @SerializedName("night") val night: Int
) {
    fun toTourDuration(): TourDuration {
        return TourDuration(
            day = day,
            night = night
        )
    }
}

