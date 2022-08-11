package com.example.torangrepository.repository.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010 \u001a\u00020!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0&H\u0016J)\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010+\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\rH\u0016J\b\u0010/\u001a\u00020\rH\u0016J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030201H\u0016J)\u00104\u001a\u0012\u0012\u0004\u0012\u0002050(j\b\u0012\u0004\u0012\u000205`*2\u0006\u0010+\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\b\u00106\u001a\u00020\rH\u0016J\b\u00107\u001a\u00020\rH\u0016J)\u00108\u001a\u0012\u0012\u0004\u0012\u0002090(j\b\u0012\u0004\u0012\u000209`*2\u0006\u0010+\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J)\u0010:\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010+\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\u0011\u0010;\u001a\u00020!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0019\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-J\u0019\u0010=\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\rH\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\rH\u0016J\u0010\u0010C\u001a\u00020!2\u0006\u0010@\u001a\u00020\rH\u0016J\u0010\u0010D\u001a\u00020!2\u0006\u0010B\u001a\u00020\rH\u0016J\u0011\u0010E\u001a\u00020!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006F"}, d2 = {"Lcom/example/torangrepository/repository/impl/TorangRepository;", "Lcom/example/torang_core/repository/InfoRepository;", "Lcom/example/torang_core/repository/ReviewRepository;", "Lcom/example/torang_core/repository/MenuRepository;", "Lcom/example/torang_core/repository/MapRepository;", "context", "Landroid/content/Context;", "restaurantService", "Lcom/example/torangrepository/services/RestaurantService;", "restaurantDao", "Lcom/example/torang_core/data/dao/RestaurantDao;", "(Landroid/content/Context;Lcom/example/torangrepository/services/RestaurantService;Lcom/example/torang_core/data/dao/RestaurantDao;)V", "_northEastLatitude", "", "get_northEastLatitude", "()D", "set_northEastLatitude", "(D)V", "_notthEastLongitude", "get_notthEastLongitude", "set_notthEastLongitude", "_southWestLatitude", "get_southWestLatitude", "set_southWestLatitude", "_southWestLongitude", "get_southWestLongitude", "set_southWestLongitude", "location", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/torang_core/data/data/Location;", "mapClick", "", "clickMap", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClickMap", "Lkotlinx/coroutines/flow/Flow;", "getCurrentLocationFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getMenus", "Ljava/util/ArrayList;", "Lcom/example/torang_core/data/model/Menu;", "Lkotlin/collections/ArrayList;", "restaurantId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNorthEastLatitude", "getNorthEastLongitude", "getRestaurant", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/torang_core/data/model/RestaurantData;", "getReviews", "Lcom/example/torang_core/data/model/Review;", "getSouthWestLatitude", "getSouthWestLongitude", "loadHours", "Lcom/example/torang_core/data/model/HoursOfOperation;", "loadMenus", "loadRestaurant", "Lcom/example/torang_core/data/model/Restaurant;", "setCurrentLocation", "(Lcom/example/torang_core/data/data/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNorthEastLatitude", "latitude", "setNorthEastLongitude", "longitude", "setSouthWestLatitude", "setSouthWestLongitude", "showCard", "library_debug"})
@javax.inject.Singleton()
@java.lang.Deprecated()
public final class TorangRepository implements com.example.torang_core.repository.InfoRepository, com.example.torang_core.repository.ReviewRepository, com.example.torang_core.repository.MenuRepository, com.example.torang_core.repository.MapRepository {
    private final com.example.torangrepository.services.RestaurantService restaurantService = null;
    private final com.example.torang_core.data.dao.RestaurantDao restaurantDao = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> mapClick = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.torang_core.data.data.Location> location = null;
    private double _northEastLatitude = 0.0;
    private double _notthEastLongitude = 0.0;
    private double _southWestLatitude = 0.0;
    private double _southWestLongitude = 0.0;
    
    @javax.inject.Inject()
    public TorangRepository(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.services.RestaurantService restaurantService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.RestaurantDao restaurantDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadRestaurant(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Restaurant> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadMenus(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Menu>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadHours(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.HoursOfOperation>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getReviews(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Review>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMenus(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Menu>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.RestaurantData>> getRestaurant() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadRestaurant(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> getClickMap() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object clickMap(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final double get_northEastLatitude() {
        return 0.0;
    }
    
    public final void set_northEastLatitude(double p0) {
    }
    
    @java.lang.Override()
    public void setNorthEastLatitude(double latitude) {
    }
    
    public final double get_notthEastLongitude() {
        return 0.0;
    }
    
    public final void set_notthEastLongitude(double p0) {
    }
    
    @java.lang.Override()
    public void setNorthEastLongitude(double longitude) {
    }
    
    public final double get_southWestLatitude() {
        return 0.0;
    }
    
    public final void set_southWestLatitude(double p0) {
    }
    
    @java.lang.Override()
    public void setSouthWestLatitude(double latitude) {
    }
    
    public final double get_southWestLongitude() {
        return 0.0;
    }
    
    public final void set_southWestLongitude(double p0) {
    }
    
    @java.lang.Override()
    public void setSouthWestLongitude(double longitude) {
    }
    
    @java.lang.Override()
    public double getNorthEastLatitude() {
        return 0.0;
    }
    
    @java.lang.Override()
    public double getNorthEastLongitude() {
        return 0.0;
    }
    
    @java.lang.Override()
    public double getSouthWestLatitude() {
        return 0.0;
    }
    
    @java.lang.Override()
    public double getSouthWestLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object showCard(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setCurrentLocation(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.data.Location location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.StateFlow<com.example.torang_core.data.data.Location> getCurrentLocationFlow() {
        return null;
    }
}