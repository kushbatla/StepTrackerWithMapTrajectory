

package com.example.android.runtracking

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.example.android.runtracking.databinding.ActivityMainBinding
import com.example.android.track.MapsActivityViewModel
import com.example.android.track.MapsActivityViewModelFactory
import com.example.android.track.TrackingApplication
import com.example.android.track.TrackingEntity
import java.util.*
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.annotations.AfterPermissionGranted
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.ACTIVITY_RECOGNITION

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, SensorEventListener {
  private lateinit var binding: ActivityMainBinding

  // ViewModel
  private val mapsActivityViewModel: MapsActivityViewModel by viewModels {
    MapsActivityViewModelFactory(getTrackingRepository())
  }

  // Location & Map
  private lateinit var mMap: GoogleMap
  private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
  private var polylineOptions = PolylineOptions()
  private val locationCallback = object: LocationCallback() {
    override fun onLocationResult(locationResult: LocationResult?) {
      super.onLocationResult(locationResult)
      locationResult ?: return
      locationResult.locations.forEach {
        val trackingEntity = TrackingEntity(Calendar.getInstance().timeInMillis, it.latitude, it.longitude)
        mapsActivityViewModel.insert(trackingEntity)
      }
    }
  }

  companion object {
    // SharedPreferences
    private const val KEY_SHARED_PREFERENCE = "com.rwRunTrackingApp.sharedPreferences"
    private const val KEY_IS_TRACKING = "com.rwRunTrackingApp.isTracking"

    // Permission
    private const val REQUEST_CODE_FINE_LOCATION = 1
    private const val REQUEST_CODE_ACTIVITY_RECOGNITION = 2
  }

  private var isTracking: Boolean
    get() = this.getSharedPreferences(KEY_SHARED_PREFERENCE, Context.MODE_PRIVATE).getBoolean(KEY_IS_TRACKING, false)
    set(value) = this.getSharedPreferences(KEY_SHARED_PREFERENCE, Context.MODE_PRIVATE).edit().putBoolean(KEY_IS_TRACKING, value).apply()

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    mapFragment.getMapAsync(this)

    // Location
    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

    // Set up button click events
    binding.startButton.setOnClickListener {
      // Clear the PolylineOptions from Google Map
      mMap.clear()

      // Update Start & End Button
      isTracking = true
      updateButtonStatus()

      // Reset the display text
      updateAllDisplayText(0, 0f)

      startTracking()
    }
    binding.endButton.setOnClickListener { endButtonClicked() }

    // Update layouts
    updateButtonStatus()

    // 1
    mapsActivityViewModel.allTrackingEntities.observe(this) { allTrackingEntities ->
      if (allTrackingEntities.isEmpty()) {
        updateAllDisplayText(0, 0f)
      }
    }

    // 2
    mapsActivityViewModel.lastTrackingEntity.observe(this) { lastTrackingEntity ->
      lastTrackingEntity ?: return@observe
      addLocationToRoute(lastTrackingEntity)
    }

    // 3
    mapsActivityViewModel.totalDistanceTravelled.observe(this) {
      it ?: return@observe
      val stepCount = mapsActivityViewModel.currentNumberOfStepCount.value ?: 0
      updateAllDisplayText(stepCount, it)
    }

    // 4
    mapsActivityViewModel.currentNumberOfStepCount.observe(this) {
      val totalDistanceTravelled = mapsActivityViewModel.totalDistanceTravelled.value ?: 0f
      updateAllDisplayText(it, totalDistanceTravelled)
    }

    // 5
    mapsActivityViewModel.allTrackingEntitiesRecord.observe(this) {
      addLocationListToRoute(it)
    }

    if (isTracking) {
      startTracking()
    }
  }

  // Repository
  private fun getTrackingApplicationInstance() = application as TrackingApplication
  private fun getTrackingRepository() = getTrackingApplicationInstance().trackingRepository

  // UI related codes
  private fun updateButtonStatus() {
    binding.startButton.isEnabled = !isTracking
    binding.endButton.isEnabled = isTracking
  }

  private fun updateAllDisplayText(stepCount: Int, totalDistanceTravelled: Float) {
    binding.numberOfStepTextView.text =  String.format("Step count: %d", stepCount)
    binding.totalDistanceTextView.text = String.format("Total distance: %.2fm", totalDistanceTravelled)

    val averagePace = if (stepCount != 0) totalDistanceTravelled / stepCount.toDouble() else 0.0
    binding.averagePaceTextView.text = String.format("Average pace: %.2fm/ step", averagePace)
  }

  private fun endButtonClicked() {
    AlertDialog.Builder(this)
        .setTitle("Are you sure to stop tracking?")
        .setPositiveButton("Confirm") { _, _ ->
          isTracking = false
          updateButtonStatus()
          stopTracking()
        }.setNegativeButton("Cancel") { _, _ ->
        }
        .create()
        .show()
  }

  // Tracking
  @AfterPermissionGranted(REQUEST_CODE_ACTIVITY_RECOGNITION)
  private fun startTracking() {
    val isActivityRecognitionPermissionFree = Build.VERSION.SDK_INT < Build.VERSION_CODES.Q
    val isActivityRecognitionPermissionGranted = EasyPermissions.hasPermissions(this,
        ACTIVITY_RECOGNITION)
    Log.d("TAG", "Is ACTIVITY_RECOGNITION permission granted $isActivityRecognitionPermissionGranted")
    if (isActivityRecognitionPermissionFree || isActivityRecognitionPermissionGranted) {
      setupStepCounterListener()
      setupLocationChangeListener()
    } else {
      // Do not have permissions, request them now
      EasyPermissions.requestPermissions(
          host = this,
          rationale = "For showing your step counts and calculate the average pace.",
          requestCode = REQUEST_CODE_ACTIVITY_RECOGNITION,
          perms = *arrayOf(ACTIVITY_RECOGNITION)
      )
    }
  }

  private fun stopTracking() {
    polylineOptions = PolylineOptions()

    mapsActivityViewModel.deleteAllTrackingEntity()
    fusedLocationProviderClient.removeLocationUpdates(locationCallback)

    // Stop step sensor listener
    val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
    sensorManager.unregisterListener(this, stepCounterSensor)
  }

  // Map related codes

  @SuppressLint("MissingPermission")
  override fun onMapReady(googleMap: GoogleMap) {
    mMap = googleMap

    showUserLocation()


    val latitude = 28.7041
    val longitude = 77.1025
    val delhiLatLong = LatLng(latitude, longitude)

    val zoomLevel = 9.5f
    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(delhiLatLong, zoomLevel))

    // Draw all the previous points on the map
    if (isTracking) {
      mapsActivityViewModel.getAllTrackingEntities()
    }
  }

  private fun addLocationListToRoute(trackingEntityList: List<TrackingEntity>) {
    if (!this::mMap.isInitialized) {
      return
    }
    mMap.clear()
    trackingEntityList.forEach { trackingEntity ->
      val newLatLngInstance = trackingEntity.asLatLng()
      polylineOptions.points.add(newLatLngInstance)
    }
    mMap.addPolyline(polylineOptions)
  }

  private fun addLocationToRoute(trackingEntity: TrackingEntity) {
    mMap.clear()
    val newLatLngInstance = trackingEntity.asLatLng()
    polylineOptions.points.add(newLatLngInstance)
    mMap.addPolyline(polylineOptions)
  }

  // Step Counter related codes
  private fun setupStepCounterListener() {
    val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
    stepCounterSensor ?: return
    sensorManager.registerListener(this@MapsActivity, stepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST)
  }

  override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    Log.d("TAG", "onAccuracyChanged: Sensor: $sensor; accuracy: $accuracy")
  }

  override fun onSensorChanged(sensorEvent: SensorEvent?) {
    Log.d("TAG", "onSensorChanged")
    sensorEvent ?: return
    val firstSensorEvent = sensorEvent.values.firstOrNull() ?: return
    Log.d("TAG", "Steps count: $firstSensorEvent ")
    val isFirstStepCountRecord = mapsActivityViewModel.currentNumberOfStepCount.value == 0
    if (isFirstStepCountRecord) {
      mapsActivityViewModel.initialStepCount = firstSensorEvent.toInt()
      mapsActivityViewModel.currentNumberOfStepCount.value = 1
    } else {
      mapsActivityViewModel.currentNumberOfStepCount.value = firstSensorEvent.toInt() - mapsActivityViewModel.initialStepCount
    }
  }

  // Location
  @AfterPermissionGranted(REQUEST_CODE_FINE_LOCATION)
  private fun showUserLocation() {
    if (EasyPermissions.hasPermissions(this, ACCESS_FINE_LOCATION)) {
      mMap.isMyLocationEnabled = true
    } else {
      // Do not have permissions, request them now
      EasyPermissions.requestPermissions(
          host = this,
          rationale = "For showing your current location on the map.",
          requestCode = REQUEST_CODE_FINE_LOCATION,
          perms = *arrayOf(ACCESS_FINE_LOCATION)
      )
    }
  }

  @AfterPermissionGranted(REQUEST_CODE_FINE_LOCATION)
  private fun setupLocationChangeListener() {
    if (EasyPermissions.hasPermissions(this, ACCESS_FINE_LOCATION)) {
      val locationRequest = LocationRequest()
      locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
      locationRequest.interval = 5000 // 5000ms (5s)
      fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
    } else {
      // Do not have permissions, request them now
      EasyPermissions.requestPermissions(
          host = this,
          rationale = "For showing your current location on the map.",
          requestCode = REQUEST_CODE_FINE_LOCATION,
          perms = *arrayOf(ACCESS_FINE_LOCATION)
      )
    }
  }

  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
      grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    // EasyPermissions handles the request result.
    EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
  }
}
