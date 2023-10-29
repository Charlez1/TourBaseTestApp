package com.stu.testapptour.network.`object`.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.`object`.ObjectItem
import com.stu.testapptour.network.blog.response.ImageResponse

data class ObjectItemResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: ImageResponse,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String
) {
    fun toObjectItem() : ObjectItem {
        return ObjectItem(
            id = id,
            image = image.toImage(),
            title = title,
            subtitle = subtitle
        )
    }
}
