package com.example.horizontravelplannerwithai.navigation
sealed class Screen(val route: String) {

    object TripPlanner : Screen("trip_planner")

    object Loading : Screen("loading")

    object TripDetails : Screen("trip_details")

    object SavedTrips : Screen("saved_trips")

    object Profile : Screen("profile")
}