

package com.example.android.track

import android.location.Location
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity
data class TrackingEntity(
    @PrimaryKey val timestamp: Long,
    @ColumnInfo val latitude: Double,
    @ColumnInfo val longitude: Double
) {
  // The distance in meter between the current Tracking Entity and the previous one in the Room database
  @ColumnInfo var distanceTravelled = 0f

  // 1
  fun asLatLng() = LatLng(latitude, longitude)

  // 2
  fun distanceTo(newTrackingEntity: TrackingEntity): Float {
    val locationA = Location("Previous Location")
    locationA.latitude = latitude
    locationA.longitude = longitude

    val locationB = Location("New Location")
    locationB.latitude = newTrackingEntity.latitude
    locationB.longitude = newTrackingEntity.longitude

    return locationA.distanceTo(locationB)
  }
}