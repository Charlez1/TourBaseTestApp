package com.stu.testapptour.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.stu.testapptour.features.blog.presetnation.BlogScreen
import com.stu.testapptour.features.home.presetnation.HomeScreen

@Composable
fun AppNavGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController  = navHostController,
        startDestination = Screen.Home.route,
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                onNavigateToBlogScreen = { blogId ->
                    navHostController.navigate(
                        route = Screen.Blog(blogId).getRouteWithArgs()
                    )
                }
            )
        }
        composable(
            route = Screen.Blog().route,
            arguments = listOf(navArgument(Screen.KEY_BLOG) { type = NavType.IntType })
        ) {
            BlogScreen(
                blogId =  it.arguments?.getInt(Screen.KEY_BLOG) ?: throw IllegalArgumentException(),
                onNavigateBack = { navHostController.popBackStack() }
            )
        }
    }
}