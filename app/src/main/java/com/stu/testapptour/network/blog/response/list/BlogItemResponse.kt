package com.stu.testapptour.network.blog.response.list

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.blog.BlogItem
import com.stu.testapptour.network.blog.response.DateResponse
import com.stu.testapptour.network.blog.response.ImageResponse

data class BlogItemResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageResponse,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("view")
    val view: Int,
    @SerializedName("like")
    val like: Int,
    @SerializedName("date")
    val date: DateResponse
) {
    fun toBlogSummary(): BlogItem {
        return BlogItem(
            id = id,
            image = image.toImage(),
            title = title,
            subtitle = subtitle,
            view = view,
            like = like,
            date = date.toDate()
        )
    }
}