package com.example.horizontravelplannerwithai.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object Home : BottomNavItem(
        route = Routes.PLAN_TRIP,
        title = "Home",
        icon = Icons.Default.Home
    )

    object Saved : BottomNavItem(
        route = Routes.SAVED_TRIPS,
        title = "Saved",
        icon = Icons.Default.Favorite
    )

    object Profile : BottomNavItem(
        route = Routes.PROFILE,
        title = "Profile",
        icon = Icons.Default.Person
    )
}