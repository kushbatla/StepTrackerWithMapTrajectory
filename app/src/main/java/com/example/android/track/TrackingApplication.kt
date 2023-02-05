

package com.example.android.track

import android.app.Application

// 1
class TrackingApplication: Application() {
  // 2
  private val trackingDatabase by lazy { TrackingDatabase.getDatabase(this) }
  val trackingRepository by lazy { TrackingRepository(trackingDatabase.getTrackingDao()) }
}
