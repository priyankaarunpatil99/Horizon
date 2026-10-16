package com.example.horizontravelplannerwithai.data.local.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var INSTANCE: HorizonDatabase? = null

    fun getDatabase(
        context: Context
    ): HorizonDatabase {

        return INSTANCE
            ?: synchronized(this) {

                val instance =
                    Room.databaseBuilder(
                        context,
                        HorizonDatabase::class.java,
                        "horizon_db"
                    ).build()

                INSTANCE = instance

                instance
            }
    }
}