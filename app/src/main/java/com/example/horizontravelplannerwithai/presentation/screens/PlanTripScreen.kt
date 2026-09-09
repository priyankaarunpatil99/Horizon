package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.horizontravelplannerwithai.navigation.Screen
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun PlanTripScreen(
    navController: NavController
) {
    var country by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    var budget by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Horizon Travel Planner",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Plan Your Trip",
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = country,
            onValueChange = {
                country = it
            },
            label = {
                Text("Country")
            }
        )
        OutlinedTextField(
            value = city,
            onValueChange = {
                city = it
            },
            label = {
                Text("City")
            }
        )
        OutlinedTextField(
            value = startDate,
            onValueChange = {
                startDate = it
            },
            label = {
                Text("Start Date")
            }
        )

        OutlinedTextField(
            value = endDate,
            onValueChange = {
                endDate = it
            },
            label = {
                Text("End Date")
            }
        )

        OutlinedTextField(
            value = budget,
            onValueChange = {
                budget = it
            },
            label = {
                Text("Budget")
            }
        )

        Button(
            onClick = {
                navController.navigate(
                    Screen.Loading.route
                )
            }
        ) {
            Text("Generate Itinerary")
        }
    }
}