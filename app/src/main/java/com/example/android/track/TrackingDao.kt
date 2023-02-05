

package com.example.android.track

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackingDao {
  // 1
  @Query("SELECT * FROM trackingentity")
  fun getAllTrackingEntities(): LiveData<List<TrackingEntity>>

  // 2
  @Query("SELECT SUM(distanceTravelled) FROM trackingentity")
  fun getTotalDistanceTravelled(): LiveData<Float?>

  // 3
  @Query("SELECT * FROM trackingentity ORDER BY timestamp DESC LIMIT 1")
  fun getLastTrackingEntity(): LiveData<TrackingEntity?>

  // 4
  @Query("SELECT * FROM trackingentity ORDER BY timestamp DESC LIMIT 1")
  suspend fun getLastTrackingEntityRecord(): TrackingEntity?

  // 5
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insert(trackingEntity: TrackingEntity)

  // 6
  @Query("DELETE FROM trackingentity")
  suspend fun deleteAll()

  // 7
  @Query("SELECT * FROM trackingentity")
  suspend fun getAllTrackingEntitiesRecord(): List<TrackingEntity>
}