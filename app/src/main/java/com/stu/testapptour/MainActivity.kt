package com.stu.testapptour

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stu.testapptour.navigation.AppNavGraph
import com.stu.testapptour.navigation.BottomBarItem
import com.stu.testapptour.navigation.Screen
import com.stu.testapptour.ui.theme.AppBottomNavigationBar
import com.stu.testapptour.ui.theme.TestAppTourTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTourTheme {
                val navHostController = rememberNavController()
                val items = listOf(
                    BottomBarItem(Screen.Home, R.string.bottom_bar_home, R.drawable.home),
                    BottomBarItem(Screen.Map, R.string.bottom_bar_map, R.drawable.map_search_outline),
                    BottomBarItem(Screen.Reservation, R.string.bottom_bar_reservation, R.drawable.shopping_outline),
                    BottomBarItem(Screen.Chat, R.string.bottom_bar_chat, R.drawable.comments),
                    BottomBarItem(Screen.More, R.string.bottom_bar_more, R.drawable.dots_horizontal)
                )

                val showBottomBar = navHostController
                    .currentBackStackEntryAsState().value?.destination?.route in items.map { it.screen.route }
                Scaffold(
                    bottomBar = {
                        if(showBottomBar)
                            AppBottomNavigationBar(
                                navHostController = navHostController,
                                items = items
                            )
                    }
                ) {
                    Column(modifier = Modifier.padding(bottom = if(showBottomBar) 75.dp else 0.dp)) {
                        AppNavGraph(navHostController)
                    }
                }
            }
        }
    }
}
