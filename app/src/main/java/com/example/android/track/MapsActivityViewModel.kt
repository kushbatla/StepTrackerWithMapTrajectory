

package com.example.android.track

import androidx.lifecycle.*
import kotlinx.coroutines.launch

// 1
class MapsActivityViewModel(private val trackingRepository: TrackingRepository): ViewModel() {

  // 2
  val allTrackingEntities: LiveData<List<TrackingEntity>> = trackingRepository.allTrackingEntities
  val allTrackingEntitiesRecord: MutableLiveData<List<TrackingEntity>> = MutableLiveData(listOf())
  val lastTrackingEntity: LiveData<TrackingEntity?> = trackingRepository.lastTrackingEntity
  val totalDistanceTravelled: LiveData<Float?> = trackingRepository.totalDistanceTravelled
  val currentNumberOfStepCount = MutableLiveData(0)
  var initialStepCount = 0

  // 4
  fun getAllTrackingEntities() = viewModelScope.launch {
    allTrackingEntitiesRecord.value =  trackingRepository.getAllTrackingEntitiesRecord()
  }

  // 3
  fun insert(trackingEntity: TrackingEntity) = viewModelScope.launch {
    trackingRepository.getLastTrackingEntityRecord()?.let {
      trackingEntity.distanceTravelled = trackingEntity.distanceTo(it)
    }
    trackingRepository.insert(trackingEntity)
  }

  fun deleteAllTrackingEntity() = viewModelScope.launch {
    currentNumberOfStepCount.value = 0
    initialStepCount = 0
    trackingRepository.deleteAll()
  }
}
