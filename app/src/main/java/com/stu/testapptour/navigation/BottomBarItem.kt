package com.stu.testapptour.navigation

import androidx.annotation.StringRes

data class BottomBarItem(
    val screen: Screen,
    @StringRes val name: Int,
    val icon: Int
)
