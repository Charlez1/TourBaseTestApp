package com.stu.testapptour.network.blog.response.info

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.blog.domain.entity.BlogInfo
import com.stu.testapptour.network.blog.response.ImageResponse
import java.text.SimpleDateFormat
import java.util.Date


data class BlogInfoDataResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("image")
    val image: ImageResponse,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("like")
    val like: Int,
    @SerializedName("date")
    val date: String,
    @SerializedName("content")
    val content: String
) {
    fun toBlogInfo(): BlogInfo {
        return BlogInfo(
            id = id,
            image = image.toImage(),
            title = title,
            subtitle = subtitle,
            like = like,
            date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(date) ?: Date(0),
            url = url,
            content = content
        )
    }
}
