package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/torangrepository/MapSharedRepositoryImpl;", "Lcom/example/torang_core/repository/MapSharedRepository;", "restaurantDao", "Lcom/example/torang_core/data/dao/RestaurantDao;", "restaurantService", "Lcom/example/torangrepository/RestaurantService;", "(Lcom/example/torang_core/data/dao/RestaurantDao;Lcom/example/torangrepository/RestaurantService;)V", "getFilterRestaurant", "", "Lcom/example/torang_core/data/model/RestaurantData;", "filter", "Lcom/example/torang_core/data/model/Filter;", "(Lcom/example/torang_core/data/model/Filter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRestaurant", "latitude", "", "longitude", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public class MapSharedRepositoryImpl implements com.example.torang_core.repository.MapSharedRepository {
    private final com.example.torang_core.data.dao.RestaurantDao restaurantDao = null;
    private final com.example.torangrepository.RestaurantService restaurantService = null;
    
    @javax.inject.Inject()
    public MapSharedRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.RestaurantDao restaurantDao, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.RestaurantService restaurantService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object searchRestaurant(double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.model.RestaurantData>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object searchRestaurant(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.model.RestaurantData>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getFilterRestaurant(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Filter filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.model.RestaurantData>> continuation) {
        return null;
    }
}