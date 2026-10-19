package com.example.horizontravelplannerwithai.presentation.state

data class PlanTripUiState(
    val country: String = "",
    val city: String = "",
    val startDate: String = "",
    val endDate: String = "",
    val budget: String = "",
    val currency: String = "INR",

    val startDateError: String? = null,
    val endDateError: String? = null,

    val tripDuration: Int = 0
)