package com.stu.testapptour.network.blog.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.blog.domain.entity.Image

data class ImageResponse(
    @SerializedName("sm")
    val sm: String,
    @SerializedName("md")
    val md: String,
    @SerializedName("lg")
    val lg: String
) {
    fun toImage(): Image {
        return Image(
            small = sm,
            medium = md,
            large = lg
        )
    }
}