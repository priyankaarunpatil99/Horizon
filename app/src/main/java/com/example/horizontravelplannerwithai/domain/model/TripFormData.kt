package com.example.horizontravelplannerwithai.domain.model

data class TripFormData(
    val country: String,
    val city: String,
    val startDate: String,
    val endDate: String,
    val budget: String,
    val currency: String
)