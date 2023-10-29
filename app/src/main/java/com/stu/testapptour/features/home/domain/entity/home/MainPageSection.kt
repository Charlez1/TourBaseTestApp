package com.stu.testapptour.features.home.domain.entity.home

import com.stu.testapptour.features.home.domain.entity.Content


data class MainPageSection(
    val title: String,
    val template: ContentTemplate,
    val url: String,
    var data: List<Content>? = null
)