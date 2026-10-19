package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.horizontravelplannerwithai.utils.DummySavedTrips
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun SavedTripsScreen(
    onViewDetails: (String, String, String) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    var showDeleteDialog by remember {
        mutableStateOf(false)
    }

    var selectedTrip by remember {
        mutableStateOf<String?>(null)
    }

    val filteredTrips = DummySavedTrips.trips.filter {

        it.city.contains(
            searchText,
            ignoreCase = true
        ) ||

                it.country.contains(
                    searchText,
                    ignoreCase = true
                )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        item {

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "✈️ Saved Trips",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Manage your travel plans",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Search Trips")
                },
                singleLine = true
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        // Empty state when no trips exist
        if (DummySavedTrips.trips.isEmpty()) {

            item {

                Box(
                    modifier = Modifier
                        .fillParentMaxSize()
                        .padding(top = 80.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "✈️",
                            style = MaterialTheme.typography.displayMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "No Saved Trips Yet"
                        )

                        Text(
                            text = "Start planning your first adventure"
                        )
                    }
                }
            }
        }

        // Empty search results state
        else if (filteredTrips.isEmpty()) {

            item {

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(24.dp)
                    ) {

                        Text(
                            text = "🔍 No Results Found",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "Try searching with a different city or country."
                        )
                    }
                }
            }
        }

        // Show trips
        else {

            items(filteredTrips) { trip ->

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "🧳",
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "${trip.city}, ${trip.country}",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = trip.dates
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        AssistChip(
                            onClick = {},
                            label = {
                                Text("Budget ₹${trip.budget}")
                            }
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        OutlinedButton(
                            onClick = {
                                onViewDetails(
                                    trip.city,
                                    trip.country,
                                    trip.budget
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("View Details")
                        }

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Button(
                            onClick = {

                                selectedTrip =
                                    "${trip.city}, ${trip.country}"

                                showDeleteDialog = true
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor =
                                    MaterialTheme.colorScheme.error
                            )
                        ) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }

    // Delete Confirmation Dialog

    if (showDeleteDialog) {

        AlertDialog(

            onDismissRequest = {
                showDeleteDialog = false
            },

            title = {
                Text("Delete Trip")
            },

            text = {
                Text(
                    "Are you sure you want to delete $selectedTrip?"
                )
            },

            confirmButton = {

                Button(
                    onClick = {

                        // TODO: Delete from Room Database

                        showDeleteDialog = false
                    }
                ) {
                    Text("Delete")
                }
            },

            dismissButton = {

                OutlinedButton(
                    onClick = {
                        showDeleteDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}