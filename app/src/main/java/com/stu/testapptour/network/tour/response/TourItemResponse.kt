package com.stu.testapptour.network.tour.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.tour.TourItem
import com.stu.testapptour.network.blog.response.ImageResponse
import com.stu.testapptour.network.room.response.DurationResponse

data class TourItemResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("title") val title: String,
    @SerializedName("location") val location: String,
    @SerializedName("date") val date: TourDateResponse,
    @SerializedName("duration") val duration: TourDurationResponse,
    @SerializedName("price") val price: TourPriceResponse,
    @SerializedName("home") val home: TourHomeResponse
) {
    fun toTourData(): TourItem {
        return TourItem(
            id = id,
            url = url,
            image = image.toImage(),
            title = title,
            location = location,
            date = date.toTourDate(),
            duration = duration.toTourDuration(),
            price = price.toTourPrice(),
            home = home.toTourHome()
        )
    }
}
