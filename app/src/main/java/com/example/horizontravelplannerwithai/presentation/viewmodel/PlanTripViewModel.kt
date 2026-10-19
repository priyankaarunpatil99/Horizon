package com.example.horizontravelplannerwithai.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horizontravelplannerwithai.domain.repository.TripRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.horizontravelplannerwithai.presentation.state.PlanTripUiState
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



class PlanTripViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(
        PlanTripUiState()
    )

    val uiState: StateFlow<PlanTripUiState> =
        _uiState.asStateFlow()

    fun updateCountry(value: String) {
        _uiState.value = _uiState.value.copy(country = value)
    }

    fun updateCity(value: String) {
        _uiState.value = _uiState.value.copy(city = value)
    }

    fun updateStartDate(value: String) {

        _uiState.value =
            _uiState.value.copy(
                startDate = value,
                startDateError = null
            )

        validateDates()

        updateDuration()
    }

    fun updateEndDate(value: String) {

        _uiState.value =
            _uiState.value.copy(
                endDate = value,
                endDateError = null
            )

        validateDates()

        updateDuration()
    }
    private fun validateDates() {

        val state = _uiState.value

        if (
            state.startDate.isBlank() ||
            state.endDate.isBlank()
        ) return

        try {

            val formatter =
                SimpleDateFormat(
                    "dd/MM/yyyy",
                    Locale.getDefault()
                )

            val start =
                formatter.parse(state.startDate)

            val end =
                formatter.parse(state.endDate)

            if (
                start != null &&
                end != null &&
                !end.after(start)
            ) {

                _uiState.value =
                    _uiState.value.copy(
                        endDateError =
                            "End date must be after start date"
                    )
            } else {

                _uiState.value =
                    _uiState.value.copy(
                        endDateError = null
                    )
            }

        } catch (_: Exception) {

        }
    }

    fun updateBudget(value: String) {
        _uiState.value = _uiState.value.copy(budget = value)
    }

    fun updateCurrency(value: String) {
        _uiState.value = _uiState.value.copy(currency = value)
    }

    private fun updateDuration() {

        val state = _uiState.value

        if (
            state.startDate.isBlank() ||
            state.endDate.isBlank()
        ) {
            return
        }

        try {

            val formatter =
                SimpleDateFormat(
                    "dd/MM/yyyy",
                    Locale.getDefault()
                )

            val start =
                formatter.parse(state.startDate)

            val end =
                formatter.parse(state.endDate)

            if (start != null && end != null) {

                val duration =
                    ((end.time - start.time)
                            / (1000 * 60 * 60 * 24))
                        .toInt()

                _uiState.value =
                    _uiState.value.copy(
                        tripDuration =
                            if (duration > 0)
                                duration
                            else
                                0
                    )
            }

        } catch (_: Exception) {

        }
    }

    fun validateForm(): Pair<Boolean, String> {

        val state = _uiState.value

        if (state.country.isBlank()) {
            return false to "Please enter country"
        }

        if (state.city.isBlank()) {
            return false to "Please enter city"
        }

        if (state.startDate.isBlank()) {
            return false to "Please select start date"
        }

        if (state.endDate.isBlank()) {
            return false to "Please select end date"
        }

        if (state.budget.isBlank()) {
            return false to "Please enter budget"
        }

        val formatter = SimpleDateFormat(
            "dd/MM/yyyy",
            Locale.getDefault()
        )

        try {

            val startDate = formatter.parse(state.startDate)
            val endDate = formatter.parse(state.endDate)

            if (startDate == null || endDate == null) {
                return false to "Invalid date"
            }

            val today = formatter.parse(
                formatter.format(Date())
            )

            if (startDate.before(today)) {
                return false to "Start date cannot be in the past"
            }

            if (!endDate.after(startDate)) {
                return false to "End date must be after start date"
            }

            val tripDays =
                ((endDate.time - startDate.time)
                        / (1000 * 60 * 60 * 24))

            if (tripDays > 30) {
                return false to "Trip duration cannot exceed 30 days"
            }

        } catch (e: Exception) {
            return false to "Invalid date format"
        }

        return true to ""
    }

    fun testGemini() {

        viewModelScope.launch {

            try {

                val repository = TripRepositoryImpl()

                val result = repository.generateTrip()

                Log.d(
                    "GEMINI_RESPONSE",
                    result
                )

            } catch (e: Exception) {

                Log.e(
                    "GEMINI_ERROR",
                    e.message ?: "Unknown Error"
                )
            }
        }
    }

}