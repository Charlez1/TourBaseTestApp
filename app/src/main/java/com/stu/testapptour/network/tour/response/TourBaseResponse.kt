package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourBase

data class TourBaseResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toTourBase(): TourBase {
        return TourBase(
            id = id,
            name = name,
            url = url
        )
    }
}
