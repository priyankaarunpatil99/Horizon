package com.example.horizontravelplannerwithai.domain.model

data class Trip(
    val id: Int = 0,
    val country: String,
    val city: String,
    val startDate: String,
    val endDate: String,
    val budget: String,
    val itinerary: String
)