

package com.example.android.track

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MapsActivityViewModelFactory(private val trackingRepository: TrackingRepository):
    ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {

    if (modelClass.isAssignableFrom(MapsActivityViewModel::class.java)) {
      @Suppress("UNCHECKED_CAST")
      return MapsActivityViewModel(trackingRepository) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}