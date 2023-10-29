package com.stu.testapptour.features.home.domain.entity.home

import com.stu.testapptour.features.home.domain.entity.home.ButtonInfo

data class MainPageData(
    val buttons: List<ButtonInfo>,
    val allSectionList: List<MainPageSection>
)