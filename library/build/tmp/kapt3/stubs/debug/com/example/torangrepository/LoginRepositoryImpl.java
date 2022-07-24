package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J\u0011\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/torangrepository/LoginRepositoryImpl;", "Lcom/example/torang_core/repository/LoginRepository;", "context", "Landroid/content/Context;", "restaurantService", "Lcom/example/torangrepository/RestaurantService;", "loggedInUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "(Landroid/content/Context;Lcom/example/torangrepository/RestaurantService;Lcom/example/torang_core/data/dao/LoggedInUserDao;)V", "facebookLogin", "Lcom/example/torang_core/data/model/User;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginUser", "Landroidx/lifecycle/LiveData;", "Lcom/example/torang_core/data/model/LoggedInUserData;", "isLogin", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLoginFlow", "Lkotlinx/coroutines/flow/Flow;", "", "setLoggedInUser", "", "loggedInUserData", "(Lcom/example/torang_core/data/model/LoggedInUserData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class LoginRepositoryImpl implements com.example.torang_core.repository.LoginRepository {
    private final android.content.Context context = null;
    private final com.example.torangrepository.RestaurantService restaurantService = null;
    private final com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao = null;
    
    @javax.inject.Inject()
    public LoginRepositoryImpl(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.RestaurantService restaurantService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object isLogin(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object facebookLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.User> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.lang.Integer> isLoginFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.LoggedInUserData> getLoginUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setLoggedInUser(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.LoggedInUserData loggedInUserData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}