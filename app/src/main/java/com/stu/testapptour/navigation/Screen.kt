package com.stu.testapptour.navigation

import androidx.annotation.StringRes
import com.stu.testapptour.R

sealed class Screen(
    val route: String
) {
    data object Home : Screen(ROUTE_HOME)
    data object Map : Screen(ROUTE_MAP)
    data object Reservation : Screen(ROUTE_RESERVATION)
    data object Chat : Screen(ROUTE_CHAT)
    data object More : Screen(ROUTE_MORE)
    data class Blog(val blogId: Int? = null) : Screen(ROUTE_BLOG_WITH_ARG) {
        fun getRouteWithArgs(): String {
            return "$ROUTE_BLOG/$blogId"
        }
    }


    companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_MAP = "map"
        const val ROUTE_RESERVATION = "reservation"
        const val ROUTE_CHAT = "chat"
        const val ROUTE_MORE = "more"
        const val ROUTE_BLOG = "blog"
        const val KEY_BLOG = "blog_id"
        const val ROUTE_BLOG_WITH_ARG = "$ROUTE_BLOG/{$KEY_BLOG}"
    }
}