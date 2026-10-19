package com.example.horizontravelplannerwithai.domain.repository

interface TripRepository {

    suspend fun generateTrip(): String
}