package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourHome
import com.stu.testapptour.network.blog.response.ImageResponse

data class TourHomeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("night") val night: Int,
    @SerializedName("url") val url: String,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("base") val base: TourBaseResponse
) {
    fun toTourHome(): TourHome {
        return TourHome(
            id = id,
            name = name,
            type = type,
            night = night,
            url = url,
            image = image.toImage(),
            base = base.toTourBase()
        )
    }
}
