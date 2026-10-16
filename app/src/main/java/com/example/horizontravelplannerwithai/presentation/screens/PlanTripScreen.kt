package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.horizontravelplannerwithai.components.CurrencyDropdown
import com.example.horizontravelplannerwithai.components.DatePickerField

import com.example.horizontravelplannerwithai.components.HorizonTextField
import com.example.horizontravelplannerwithai.presentation.viewmodel.PlanTripViewModel
@Composable
fun HorizonHeader() {
    Spacer(modifier = Modifier.height(20.dp))

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xFF0077B6),
                            Color(0xFF00B4D8)
                        )
                    )
                )
                .padding(24.dp)
        ) {

            Column {

                Text(
                    text = "✈ Horizon",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Plan smarter with AI",
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun PlanTripScreen(
    onGenerateClick: (
        country: String,
        city: String,
        startDate: String,
        endDate: String,
        budget: String,
        currency: String
    ) -> Unit
) {


    val viewModel: PlanTripViewModel = viewModel()

    val state by viewModel.uiState.collectAsState()

    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizonHeader()

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Trip Details",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                HorizonTextField(
                    value = state.country,
                    label = "Country",
                    onValueChange = {
                        viewModel.updateCountry(it)
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                HorizonTextField(
                    value = state.city,
                    label = "City",
                    onValueChange = {
                        viewModel.updateCity(it)
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                DatePickerField(
                    label = "Start Date",
                    selectedDate = state.startDate,
                    onDateSelected = {
                        viewModel.updateStartDate(it)
                    }
                )
                state.startDateError?.let {

                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                DatePickerField(
                    label = "End Date",
                    selectedDate = state.endDate,
                    onDateSelected = {
                        viewModel.updateEndDate(it)
                    }
                )
                state.endDateError?.let {

                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                if (state.tripDuration > 0) {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    AssistChip(
                        onClick = {},
                        label = {
                            Text(
                                "Trip Duration: ${state.tripDuration} Days"
                            )
                        }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                HorizonTextField(
                    value = state.budget,
                    label = "Budget",
                    onValueChange = {
                        viewModel.updateBudget(it)
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                CurrencyDropdown(
                    selectedCurrency = state.currency,
                    onCurrencySelected = {
                        viewModel.updateCurrency(it)
                    }
                )
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                val validation = viewModel.validateForm()

                if (validation.first) {

                    errorMessage = ""
                    onGenerateClick(
                        state.country,
                        state.city,
                        state.startDate,
                        state.endDate,
                        state.budget,
                        state.currency
                    )

                } else {

                    errorMessage = validation.second
                }
//                viewModel.testGemini()

            }
        ) {
            Text("Generate Itinerary")
        }

        if (errorMessage.isNotEmpty()) {

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}