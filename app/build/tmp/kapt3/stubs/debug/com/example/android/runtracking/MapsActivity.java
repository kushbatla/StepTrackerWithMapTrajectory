package com.example.android.runtracking;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0002J\u001a\u0010\'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0012H\u0017J-\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020+2\u000e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u000205042\u0006\u00106\u001a\u000207H\u0016\u00a2\u0006\u0002\u00108J\u0012\u00109\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u001cH\u0003J\b\u0010=\u001a\u00020\u001cH\u0002J\b\u0010>\u001a\u00020\u001cH\u0003J\b\u0010?\u001a\u00020\u001cH\u0003J\b\u0010@\u001a\u00020\u001cH\u0002J\u0018\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/example/android/runtracking/MapsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Landroid/hardware/SensorEventListener;", "()V", "binding", "Lcom/example/android/runtracking/databinding/ActivityMainBinding;", "fusedLocationProviderClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "value", "", "isTracking", "()Z", "setTracking", "(Z)V", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mapsActivityViewModel", "Lcom/example/android/track/MapsActivityViewModel;", "getMapsActivityViewModel", "()Lcom/example/android/track/MapsActivityViewModel;", "mapsActivityViewModel$delegate", "Lkotlin/Lazy;", "polylineOptions", "Lcom/google/android/gms/maps/model/PolylineOptions;", "addLocationListToRoute", "", "trackingEntityList", "", "Lcom/example/android/track/TrackingEntity;", "addLocationToRoute", "trackingEntity", "endButtonClicked", "getTrackingApplicationInstance", "Lcom/example/android/track/TrackingApplication;", "getTrackingRepository", "Lcom/example/android/track/TrackingRepository;", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSensorChanged", "sensorEvent", "Landroid/hardware/SensorEvent;", "setupLocationChangeListener", "setupStepCounterListener", "showUserLocation", "startTracking", "stopTracking", "updateAllDisplayText", "stepCount", "totalDistanceTravelled", "", "updateButtonStatus", "Companion", "app_debug"})
public final class MapsActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback, android.hardware.SensorEventListener {
    private com.example.android.runtracking.databinding.ActivityMainBinding binding;
    private final kotlin.Lazy mapsActivityViewModel$delegate = null;
    private com.google.android.gms.maps.GoogleMap mMap;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationProviderClient;
    private com.google.android.gms.maps.model.PolylineOptions polylineOptions;
    private final com.google.android.gms.location.LocationCallback locationCallback = null;
    private static final java.lang.String KEY_SHARED_PREFERENCE = "com.rwRunTrackingApp.sharedPreferences";
    private static final java.lang.String KEY_IS_TRACKING = "com.rwRunTrackingApp.isTracking";
    private static final int REQUEST_CODE_FINE_LOCATION = 1;
    private static final int REQUEST_CODE_ACTIVITY_RECOGNITION = 2;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.android.runtracking.MapsActivity.Companion Companion = null;
    
    private final com.example.android.track.MapsActivityViewModel getMapsActivityViewModel() {
        return null;
    }
    
    private final boolean isTracking() {
        return false;
    }
    
    private final void setTracking(boolean value) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final com.example.android.track.TrackingApplication getTrackingApplicationInstance() {
        return null;
    }
    
    private final com.example.android.track.TrackingRepository getTrackingRepository() {
        return null;
    }
    
    private final void updateButtonStatus() {
    }
    
    private final void updateAllDisplayText(int stepCount, float totalDistanceTravelled) {
    }
    
    private final void endButtonClicked() {
    }
    
    @com.vmadalin.easypermissions.annotations.AfterPermissionGranted(value = 2)
    private final void startTracking() {
    }
    
    private final void stopTracking() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    private final void addLocationListToRoute(java.util.List<com.example.android.track.TrackingEntity> trackingEntityList) {
    }
    
    private final void addLocationToRoute(com.example.android.track.TrackingEntity trackingEntity) {
    }
    
    private final void setupStepCounterListener() {
    }
    
    @java.lang.Override()
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable()
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    @java.lang.Override()
    public void onSensorChanged(@org.jetbrains.annotations.Nullable()
    android.hardware.SensorEvent sensorEvent) {
    }
    
    @com.vmadalin.easypermissions.annotations.AfterPermissionGranted(value = 1)
    private final void showUserLocation() {
    }
    
    @com.vmadalin.easypermissions.annotations.AfterPermissionGranted(value = 1)
    private final void setupLocationChangeListener() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public MapsActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/android/runtracking/MapsActivity$Companion;", "", "()V", "KEY_IS_TRACKING", "", "KEY_SHARED_PREFERENCE", "REQUEST_CODE_ACTIVITY_RECOGNITION", "", "REQUEST_CODE_FINE_LOCATION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}