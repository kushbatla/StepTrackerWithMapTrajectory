

package com.example.android.track

import androidx.annotation.WorkerThread

// 1
class TrackingRepository(private val trackingDao: TrackingDao) {

  // 2
  val allTrackingEntities = trackingDao.getAllTrackingEntities()
  val lastTrackingEntity = trackingDao.getLastTrackingEntity()
  val totalDistanceTravelled = trackingDao.getTotalDistanceTravelled()

  // 3
  @Suppress("RedundantSuspendModifier")
  @WorkerThread
  suspend fun getLastTrackingEntityRecord() = trackingDao.getLastTrackingEntityRecord()

  @Suppress("RedundantSuspendModifier")
  @WorkerThread
  suspend fun insert(trackingEntity: TrackingEntity) {
    trackingDao.insert(trackingEntity)
  }

  @Suppress("RedundantSuspendModifier")
  @WorkerThread
  suspend fun deleteAll() {
    trackingDao.deleteAll()
  }

  @Suppress("RedundantSuspendModifier")
  @WorkerThread
  suspend fun getAllTrackingEntitiesRecord() = trackingDao.getAllTrackingEntitiesRecord()
}
