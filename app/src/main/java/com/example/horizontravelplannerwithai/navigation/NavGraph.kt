package com.example.horizontravelplannerwithai.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.horizontravelplannerwithai.presentation.screens.*



@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.TripPlanner.route
    ) {

        composable(Screen.TripPlanner.route) {
            PlanTripScreen(navController)
        }

        composable(Screen.Loading.route) {
            LoadingScreen(navController)
        }

        composable(Screen.TripDetails.route) {
            TripDetailsScreen(navController)
        }

        composable(Screen.SavedTrips.route) {
            SavedTripsScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}