package com.example.horizontravelplannerwithai.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    label: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    OutlinedButton(
        onClick = {
            showDialog = true
        },
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = if (selectedDate.isEmpty())
                label
            else
                selectedDate,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Select Date"
        )
    }

    if (showDialog) {

        val datePickerState = rememberDatePickerState(

            selectableDates = object : SelectableDates {

                override fun isSelectableDate(
                    utcTimeMillis: Long
                ): Boolean {

                    return utcTimeMillis >=
                            System.currentTimeMillis() -
                            24 * 60 * 60 * 1000
                }
            }
        )


        DatePickerDialog(
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {

                        datePickerState.selectedDateMillis?.let {

                            val formatter = SimpleDateFormat(
                                "dd/MM/yyyy",
                                Locale.getDefault()
                            )

                            onDateSelected(
                                formatter.format(Date(it))
                            )
                        }

                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {

            DatePicker(
                state = datePickerState
            )
        }
    }
}