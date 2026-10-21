package com.example.horizontravelplannerwithai.presentation.screens;

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "👤",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Priyanka Patil",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Travel Planner Enthusiast",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Stats Row 1

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            ElevatedCard(
                modifier = Modifier.weight(1f)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "12",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text("Trips")
                }
            }

            ElevatedCard(
                modifier = Modifier.weight(1f)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "4",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text("Countries")
                }
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        // Stats Row 2

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            ElevatedCard(
                modifier = Modifier.weight(1f)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "8",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text("Saved")
                }
            }

            ElevatedCard(
                modifier = Modifier.weight(1f)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "₹80K",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text("Budget")
                }
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Recent Activity

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Recent Activity",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text("✅ Planned Goa Trip")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("✅ Saved Pune Trip")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("✅ Viewed Budget Summary")
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Settings

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text("🌙 Dark Mode")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("🔔 Notifications")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("ℹ️ About App")
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )
    }
}