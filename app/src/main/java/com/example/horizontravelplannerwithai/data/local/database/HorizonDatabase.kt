package com.example.horizontravelplannerwithai.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.horizontravelplannerwithai.data.local.dao.TripDao
import com.example.horizontravelplannerwithai.data.local.entity.TripEntity

@Database(
    entities = [TripEntity::class],
    version = 1
)
abstract class HorizonDatabase : RoomDatabase() {

    abstract fun tripDao(): TripDao
}