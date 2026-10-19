package com.example.horizontravelplannerwithai.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.horizontravelplannerwithai.data.local.database.DatabaseProvider
import com.example.horizontravelplannerwithai.data.local.entity.TripEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SavedTripsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val dao =
        DatabaseProvider
            .getDatabase(application)
            .tripDao()

    val trips =
        dao.getTrips()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(),
                emptyList()
            )

    fun saveTrip(
        trip: TripEntity
    ) {

        viewModelScope.launch {

            dao.insertTrip(trip)
        }
    }

    fun deleteTrip(
        trip: TripEntity
    ) {

        viewModelScope.launch {

            dao.deleteTrip(trip)
        }
    }
}