package com.example.horizontravelplannerwithai.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.horizontravelplannerwithai.components.BottomBar
import com.example.horizontravelplannerwithai.presentation.screens.*

@Composable
fun HorizonNavGraph() {

    val navController = rememberNavController()

    var country by remember {
        mutableStateOf("")
    }

    var city by remember {
        mutableStateOf("")
    }

    var budget by remember {
        mutableStateOf("")
    }

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Routes.PLAN_TRIP,
            modifier = Modifier.padding(paddingValues)
        ) {

            // Plan Trip

            composable(Routes.PLAN_TRIP) {

                PlanTripScreen(
                    onGenerateClick = { c, ct, sd, ed, b, cur ->

                        country = c
                        city = ct
                        budget = b

                        navController.navigate(
                            Routes.LOADING
                        )
                    }
                )
            }

            // Loading

            composable(Routes.LOADING) {

                LoadingScreen(
                    onFinished = {
                        navController.navigate(
                            Routes.TRIP_DETAILS
                        ) {
                            popUpTo(Routes.LOADING) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            // Trip Details

            composable(Routes.TRIP_DETAILS) {

                TripDetailsScreen(
                    country = country,
                    city = city,
                    budget = budget,

                    onSaveTrip = {

                        navController.navigate(
                            Routes.BUDGET_SUMMARY
                        ) {
                            launchSingleTop = true
                        }
                    },

                    onViewSavedTrips = {

                        navController.navigate(
                            Routes.SAVED_TRIPS
                        )
                    }
                )
            }

            // Budget Summary

            composable(Routes.BUDGET_SUMMARY) {

                BudgetSummaryScreen(
                    budget = budget,

                    onViewSavedTrips = {

                        navController.navigate(
                            Routes.SAVED_TRIPS
                        ) {
                            popUpTo(Routes.TRIP_DETAILS)
                        }
                    }
                )
            }

            // Saved Trips

            composable(Routes.SAVED_TRIPS) {

                SavedTripDetailScreen(
                    city = city,
                    country = country,
                    budget = budget,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            // Saved Trip Detail

            composable(
                route = Routes.SAVED_TRIP_DETAIL
            ) { backStackEntry ->

                val city =
                    backStackEntry.arguments
                        ?.getString("city") ?: ""

                val country =
                    backStackEntry.arguments
                        ?.getString("country") ?: ""

                val budget =
                    backStackEntry.arguments
                        ?.getString("budget") ?: ""

                SavedTripDetailScreen(
                    city = city,
                    country = country,
                    budget = budget,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
            // Profile

            composable(Routes.PROFILE) {

                ProfileScreen()
            }
        }
    }
}
