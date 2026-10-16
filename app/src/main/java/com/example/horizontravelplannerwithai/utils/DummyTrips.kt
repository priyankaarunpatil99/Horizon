package com.example.horizontravelplannerwithai.utils

import com.example.horizontravelplannerwithai.domain.model.ItineraryDay

object DummyTrips {

    val itinerary = listOf(

        ItineraryDay(
            day = "Day 1",
            place = "Shaniwar Wada",
            description = "Explore Pune's historic fort.",
            cost = "₹1500"
        ),

        ItineraryDay(
            day = "Day 2",
            place = "Aga Khan Palace",
            description = "Visit the iconic palace.",
            cost = "₹1200"
        ),

        ItineraryDay(
            day = "Day 3",
            place = "Sinhagad Fort",
            description = "Trek and enjoy local food.",
            cost = "₹2000"
        )
    )
}