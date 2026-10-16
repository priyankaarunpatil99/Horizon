package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BudgetSummaryScreen(
    budget: String,
    onViewSavedTrips: () -> Unit
) {

    val totalBudget = budget.toIntOrNull() ?: 0

    val hotel = (totalBudget * 0.4).toInt()
    val food = (totalBudget * 0.2).toInt()
    val transport = (totalBudget * 0.15).toInt()
    val activities = (totalBudget * 0.25).toInt()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Budget Summary",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Total Budget ₹$totalBudget",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text("🏨 Hotel: ₹$hotel")
                Text("🍽 Food: ₹$food")
                Text("🚕 Transport: ₹$transport")
                Text("🎟 Activities: ₹$activities")
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        LinearProgressIndicator(
            progress = { 1f },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Button(
            onClick = {
                onViewSavedTrips()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}