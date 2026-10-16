package com.example.horizontravelplannerwithai.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyDropdown(
    selectedCurrency: String,
    onCurrencySelected: (String) -> Unit
) {

    val currencies = listOf(
        "INR",
        "USD",
        "EUR",
        "GBP",
        "JPY"
    )

    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        OutlinedTextField(
            value = selectedCurrency,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("Currency")
            },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {

            currencies.forEach { currency ->

                DropdownMenuItem(
                    text = {
                        Text(currency)
                    },
                    onClick = {

                        onCurrencySelected(currency)
                        expanded = false
                    }
                )
            }
        }
    }
}