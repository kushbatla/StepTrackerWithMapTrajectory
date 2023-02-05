package com.example.android.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\t\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/android/track/MapsActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "trackingRepository", "Lcom/example/android/track/TrackingRepository;", "(Lcom/example/android/track/TrackingRepository;)V", "allTrackingEntities", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/android/track/TrackingEntity;", "getAllTrackingEntities", "()Landroidx/lifecycle/LiveData;", "allTrackingEntitiesRecord", "Landroidx/lifecycle/MutableLiveData;", "getAllTrackingEntitiesRecord", "()Landroidx/lifecycle/MutableLiveData;", "currentNumberOfStepCount", "", "kotlin.jvm.PlatformType", "getCurrentNumberOfStepCount", "initialStepCount", "getInitialStepCount", "()I", "setInitialStepCount", "(I)V", "lastTrackingEntity", "getLastTrackingEntity", "totalDistanceTravelled", "", "getTotalDistanceTravelled", "deleteAllTrackingEntity", "Lkotlinx/coroutines/Job;", "insert", "trackingEntity", "app_debug"})
public final class MapsActivityViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.android.track.TrackingEntity>> allTrackingEntities = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.android.track.TrackingEntity>> allTrackingEntitiesRecord = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.android.track.TrackingEntity> lastTrackingEntity = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Float> totalDistanceTravelled = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> currentNumberOfStepCount = null;
    private int initialStepCount = 0;
    private final com.example.android.track.TrackingRepository trackingRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.android.track.TrackingEntity>> getAllTrackingEntities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.android.track.TrackingEntity>> getAllTrackingEntitiesRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.android.track.TrackingEntity> getLastTrackingEntity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Float> getTotalDistanceTravelled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentNumberOfStepCount() {
        return null;
    }
    
    public final int getInitialStepCount() {
        return 0;
    }
    
    public final void setInitialStepCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getAllTrackingEntities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.example.android.track.TrackingEntity trackingEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteAllTrackingEntity() {
        return null;
    }
    
    public MapsActivityViewModel(@org.jetbrains.annotations.NotNull()
    com.example.android.track.TrackingRepository trackingRepository) {
        super();
    }
}