package com.stu.testapptour.network.main.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.home.ButtonInfo

data class ButtonInfoResponse(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) {
    fun toButtonInfo() : ButtonInfo {
        return ButtonInfo(
            icon = icon,
            color = color,
            title = title,
            type = type,
            url = url
        )
    }
}