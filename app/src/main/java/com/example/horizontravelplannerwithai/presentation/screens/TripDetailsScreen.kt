package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.horizontravelplannerwithai.data.local.entity.TripEntity

import com.example.horizontravelplannerwithai.presentation.viewmodel.SavedTripsViewModel
import com.example.horizontravelplannerwithai.utils.DummyTrips
import androidx.compose.foundation.layout.FlowRow

@Composable
fun TripDetailsScreen(
    country: String,
    city: String,
    budget: String,
    onSaveTrip: () -> Unit,
    onViewSavedTrips: () -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp,
            bottom = 100.dp
        )
    ) {

        // Trip Summary
        item {
            Spacer(
                modifier = Modifier.height(20.dp)
            )

            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Trip Summary",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    HorizontalDivider()

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "🌍 Country: $country",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "📍 City: $city",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "💰 Budget: ₹$budget",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        // Day wise itinerary
        items(DummyTrips.itinerary) { day ->

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = day.day,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = day.place,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = day.description
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    AssistChip(
                        onClick = {},
                        label = {
                            Text("Cost ${day.cost}")
                        }
                    )
                }
            }

        }

        // Bottom buttons
        item {

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Button(
                onClick = {
                    onSaveTrip()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Trip")
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            OutlinedButton(
                onClick = {
                    onViewSavedTrips()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("View Saved Trips")
            }

            Spacer(
                modifier = Modifier.height(48.dp)
            )
        }
    }
}