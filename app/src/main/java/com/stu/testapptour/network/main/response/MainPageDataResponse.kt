package com.stu.testapptour.network.main.response

import com.google.gson.annotations.SerializedName
import com.stu.testapptour.features.home.domain.entity.home.MainPageData
import com.stu.testapptour.features.home.domain.entity.home.MainPageSection

data class MainPageDataResponse(
    @SerializedName("buttons")
    val buttons: List<ButtonInfoResponse>,
    @SerializedName("content")
    val content: List<MainPageContentResponse>
) {
    fun toMainPageData() : MainPageData {
        return MainPageData(
            buttons = buttons.map { it.toButtonInfo() },
            allSectionList = content.map { it.toMainPageContent() }
        )
    }
}