package com.stu.testapptour.ui.theme

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.stu.testapptour.navigation.BottomBarItem
import com.stu.testapptour.navigation.Screen

@Composable
fun AppBottomNavigationBar(
    navHostController: NavHostController,
    items: List<BottomBarItem>
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onBackground,
        contentColor = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.height(75.dp)
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { bottomBarItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(bottomBarItem.icon),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        stringResource(bottomBarItem.name),
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == bottomBarItem.screen.route || it.route == Screen.Blog().route } == true,
                onClick = {
                    navHostController.navigate(bottomBarItem.screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = MaterialTheme.colorScheme.tertiary,
                        selectedTextColor = MaterialTheme.colorScheme.tertiary,
                        indicatorColor = MaterialTheme.colorScheme.onBackground
                    )
            )
        }
    }
}