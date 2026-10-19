package com.example.horizontravelplannerwithai.data.local.dao

import androidx.room.*
import com.example.horizontravelplannerwithai.data.local.entity.TripEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDao {

    @Insert
    suspend fun insertTrip(
        trip: TripEntity
    )

    @Query("SELECT * FROM trips ORDER BY id DESC")
    fun getTrips(): Flow<List<TripEntity>>

    @Delete
    suspend fun deleteTrip(
        trip: TripEntity
    )
}
