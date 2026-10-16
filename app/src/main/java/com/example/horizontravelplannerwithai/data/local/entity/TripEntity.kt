package com.example.horizontravelplannerwithai.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trips")
data class TripEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val country: String,
    val city: String,
    val startDate: String,
    val endDate: String,
    val budget: String,
    val itinerary: String
)