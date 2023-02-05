

package com.example.android.track

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 1
@Database(entities = [TrackingEntity::class], version = 1)

// 2
abstract class TrackingDatabase : RoomDatabase() {

  // 3
  abstract fun getTrackingDao(): TrackingDao

  companion object {
    // 4
    @Volatile
    private var INSTANCE: TrackingDatabase? = null

    fun getDatabase(context: Context): TrackingDatabase {
      return INSTANCE ?: synchronized(this) {
        INSTANCE = Room.databaseBuilder(context.applicationContext, TrackingDatabase::class.java,"run_database").build()
        INSTANCE!!
      }
    }
  }
}