package com.example.horizontravelplannerwithai.presentation.screens;

import androidx.compose.foundation.layout.*
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
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "👤",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Priyanka Patil",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Travel Planner Enthusiast"
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Trips Planned: 12")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("Countries Explored: 4")

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text("Saved Trips: 8")
            }
        }
    }
}