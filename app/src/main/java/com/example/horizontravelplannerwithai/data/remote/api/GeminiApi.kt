package com.example.horizontravelplannerwithai.data.remote.api

import com.example.horizontravelplannerwithai.data.remote.dto.GeminiRequest
import com.example.horizontravelplannerwithai.data.remote.dto.GeminiResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApi {

    @POST("v1beta/models/gemini-1.5-flash:generateContent")
    suspend fun generateTripPlan(

        @Query("key")
        apiKey: String,

        @Body
        request: GeminiRequest

    ): GeminiResponse
}