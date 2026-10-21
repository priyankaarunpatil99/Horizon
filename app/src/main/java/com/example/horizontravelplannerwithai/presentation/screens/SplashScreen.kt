package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {

    LaunchedEffect(Unit) {

        delay(2000)

        onSplashFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "✈️",
                style = MaterialTheme.typography.displayLarge
            )

            Text(
                text = "Horizon",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Travel Planner"
            )
        }
    }
}