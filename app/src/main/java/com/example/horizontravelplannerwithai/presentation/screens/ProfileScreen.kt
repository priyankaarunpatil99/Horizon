package com.example.horizontravelplannerwithai.presentation.screens;

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.horizontravelplannerwithai.navigation.Screen

@Composable
fun ProfileScreen(
        navController: NavController
) {

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
    ) {

        Text(
                text = "Profile",
                style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Priyanka Patil")
        Text("Horizon User")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
                onClick = {
                        navController.navigate(
                                Screen.TripPlanner.route
                        )
                }
        ) {
            Text("Back To Planner")
        }
    }
}