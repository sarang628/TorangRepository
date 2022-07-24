package com.example.torangrepository.test;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\bH\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/torangrepository/test/TestAlarmRepositoryImpl;", "Lcom/example/torang_core/repository/AlarmRepository;", "loggedInUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "restaurantService", "Lcom/example/torangrepository/RestaurantService;", "(Lcom/example/torang_core/data/dao/LoggedInUserDao;Lcom/example/torangrepository/RestaurantService;)V", "isLogin", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "deleteAlarm", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAlarm", "Ljava/util/ArrayList;", "Lcom/example/torang_core/data/model/Alarm;", "Lkotlin/collections/ArrayList;", "user", "Lcom/example/torang_core/data/model/LoggedInUserData;", "library_debug"})
@javax.inject.Singleton()
public final class TestAlarmRepositoryImpl implements com.example.torang_core.repository.AlarmRepository {
    private final com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao = null;
    private final com.example.torangrepository.RestaurantService restaurantService = null;
    
    @javax.inject.Inject()
    public TestAlarmRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.RestaurantService restaurantService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadAlarm(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Alarm>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteAlarm(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.LoggedInUserData> user() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.lang.Boolean> isLogin() {
        return null;
    }
}