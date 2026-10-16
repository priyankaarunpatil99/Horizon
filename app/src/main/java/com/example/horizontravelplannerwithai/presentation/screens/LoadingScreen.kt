package com.example.horizontravelplannerwithai.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    onFinished: () -> Unit
) {

    val tips = listOf(
        "✈️ Finding the best attractions...",
        "🍜 Searching food recommendations...",
        "📍 Building your itinerary...",
        "💰 Optimizing your budget...",
        "🤖 AI is generating your trip..."
    )

    var tipIndex by remember {
        mutableStateOf(0)
    }

    var progress by remember {
        mutableFloatStateOf(0f)
    }


    LaunchedEffect(Unit) {

        repeat(5) {

            delay(1000)

            progress += 0.2f

            tipIndex = (tipIndex + 1) % tips.size
        }

        onFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CircularProgressIndicator()

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Text(
                    text = "Generating Your Trip",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = tips[tipIndex],
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
