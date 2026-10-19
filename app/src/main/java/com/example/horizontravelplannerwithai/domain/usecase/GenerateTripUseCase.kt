package com.example.horizontravelplannerwithai.domain.usecase

import com.example.horizontravelplannerwithai.domain.repository.TripRepository

class GenerateTripUseCase(
    private val repository: TripRepository
) {

    suspend operator fun invoke(): String {

        return repository.generateTrip()
    }
}