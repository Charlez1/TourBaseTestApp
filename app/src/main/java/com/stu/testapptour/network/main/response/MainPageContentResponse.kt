package com.stu.testapptour.network.main.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.home.MainPageSection

data class MainPageContentResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("template")
    val template: ContentTemplateResponse,
    @SerializedName("url")
    val url: String
) {
    fun toMainPageContent() : MainPageSection {
        return MainPageSection(
            title = title,
            template = template.toContentTemplate(),
            url = url
        )
    }
}
