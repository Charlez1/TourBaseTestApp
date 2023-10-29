package com.stu.testapptour.navigation

sealed class Screen(
    val route: String
) {

    data object Home : Screen(ROUTE_HOME)
    data class Blog(val blogId: Int? = null) : Screen(ROUTE_BLOG_WITH_ARG) {
        fun getRouteWithArgs(): String {
            return "$ROUTE_BLOG/$blogId"
        }
    }


    companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_BLOG = "blog"
        const val KEY_BLOG = "blog_id"
        const val ROUTE_BLOG_WITH_ARG = "$ROUTE_BLOG/{$KEY_BLOG}"
    }
}