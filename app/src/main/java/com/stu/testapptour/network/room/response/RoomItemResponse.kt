package com.stu.testapptour.network.room.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.room.RoomItem
import com.stu.testapptour.network.blog.response.ImageResponse

data class RoomItemResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageResponse,
    @SerializedName("title")
    val title: String,
    @SerializedName("date")
    val date: Date,
    @SerializedName("duration")
    val duration: DurationResponse,
    @SerializedName("price")
    val price: PriceResponse,
    @SerializedName("countTourist")
    val countTourist: Int,
    @SerializedName("type")
    val type: String
) {
    fun toRoomItem(): RoomItem {
        return RoomItem(
            id= id,
            image = image.toImage(),
            title = title,
            price = price.toPrice(),
            countTourist = countTourist,
            type = type
        )
    }
}