package com.example.android.track;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\'J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006H\'J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/android/track/TrackingDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTrackingEntities", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/android/track/TrackingEntity;", "getAllTrackingEntitiesRecord", "getLastTrackingEntity", "getLastTrackingEntityRecord", "getTotalDistanceTravelled", "", "insert", "trackingEntity", "(Lcom/example/android/track/TrackingEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TrackingDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM trackingentity")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.android.track.TrackingEntity>> getAllTrackingEntities();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT SUM(distanceTravelled) FROM trackingentity")
    public abstract androidx.lifecycle.LiveData<java.lang.Float> getTotalDistanceTravelled();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM trackingentity ORDER BY timestamp DESC LIMIT 1")
    public abstract androidx.lifecycle.LiveData<com.example.android.track.TrackingEntity> getLastTrackingEntity();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM trackingentity ORDER BY timestamp DESC LIMIT 1")
    public abstract java.lang.Object getLastTrackingEntityRecord(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.android.track.TrackingEntity> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.android.track.TrackingEntity trackingEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM trackingentity")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM trackingentity")
    public abstract java.lang.Object getAllTrackingEntitiesRecord(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.android.track.TrackingEntity>> p0);
}