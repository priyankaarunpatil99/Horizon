package com.example.horizontravelplannerwithai.domain.repository

import com.example.horizontravelplannerwithai.BuildConfig
import com.example.horizontravelplannerwithai.data.remote.api.RetrofitClient
import com.example.horizontravelplannerwithai.data.remote.dto.Content
import com.example.horizontravelplannerwithai.data.remote.dto.GeminiRequest
import com.example.horizontravelplannerwithai.data.remote.dto.Part
import com.example.horizontravelplannerwithai.domain.repository.TripRepository

class TripRepositoryImpl : TripRepository {

    override suspend fun generateTrip(): String {

        val prompt = """
            Create a 3 day detailed itinerary for Pune.
            Include:
            - Attractions
            - Food
            - Estimated costs
            - Travel tips
        """.trimIndent()

        val request = GeminiRequest(
            contents = listOf(
                Content(
                    parts = listOf(
                        Part(prompt)
                    )
                )
            )
        )

        val response =
            RetrofitClient.api.generateTripPlan(
                apiKey = BuildConfig.GEMINI_API_KEY,
                request = request
            )

        return response
            .candidates
            .first()
            .content
            .parts
            .first()
            .text
    }
}