package com.example.torangrepository.repository.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010 \u001a\u00020\u001aJ\u0013\u0010!\u001a\u0004\u0018\u00010\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/example/torangrepository/repository/impl/MyReviewsRepositoryImpl;", "Lcom/example/torang_core/repository/MyReviewsRepository;", "context", "Landroid/content/Context;", "restaurantService", "Lcom/example/torangrepository/services/RestaurantService;", "userDao", "Lcom/example/torang_core/data/dao/UserDao;", "myReviewDao", "Lcom/example/torang_core/data/dao/MyReviewDao;", "loggedInUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "myReviewsLocalDataSource", "Lcom/example/torang_core/datasource/local/MyReviewsLocalDataSource;", "myReviewsRemoteDataSource", "Lcom/example/torang_core/datasource/local/MyReviewsRemoteDataSource;", "(Landroid/content/Context;Lcom/example/torangrepository/services/RestaurantService;Lcom/example/torang_core/data/dao/UserDao;Lcom/example/torang_core/data/dao/MyReviewDao;Lcom/example/torang_core/data/dao/LoggedInUserDao;Lcom/example/torang_core/datasource/local/MyReviewsLocalDataSource;Lcom/example/torang_core/datasource/local/MyReviewsRemoteDataSource;)V", "getLoggedInUserDao$annotations", "()V", "getMyReviewDao$annotations", "getRestaurantService$annotations", "getUserDao$annotations", "getMyReviews", "", "Lcom/example/torang_core/data/data/ReviewAndImage;", "restaurantId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyReviews1", "Landroidx/lifecycle/LiveData;", "getMyReviews3", "Lcom/example/torang_core/data/data/MyReview;", "userId", "userId1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class MyReviewsRepositoryImpl implements com.example.torang_core.repository.MyReviewsRepository {
    private final android.content.Context context = null;
    @java.lang.Deprecated()
    private final com.example.torangrepository.services.RestaurantService restaurantService = null;
    @java.lang.Deprecated()
    private final com.example.torang_core.data.dao.UserDao userDao = null;
    @java.lang.Deprecated()
    private final com.example.torang_core.data.dao.MyReviewDao myReviewDao = null;
    @java.lang.Deprecated()
    private final com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao = null;
    private final com.example.torang_core.datasource.local.MyReviewsLocalDataSource myReviewsLocalDataSource = null;
    private final com.example.torang_core.datasource.local.MyReviewsRemoteDataSource myReviewsRemoteDataSource = null;
    
    @javax.inject.Inject()
    public MyReviewsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.services.RestaurantService restaurantService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.MyReviewDao myReviewDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.datasource.local.MyReviewsLocalDataSource myReviewsLocalDataSource, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.datasource.local.MyReviewsRemoteDataSource myReviewsRemoteDataSource) {
        super();
    }
    
    @java.lang.Deprecated()
    private static void getRestaurantService$annotations() {
    }
    
    @java.lang.Deprecated()
    private static void getUserDao$annotations() {
    }
    
    @java.lang.Deprecated()
    private static void getMyReviewDao$annotations() {
    }
    
    @java.lang.Deprecated()
    private static void getLoggedInUserDao$annotations() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMyReviews(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.data.ReviewAndImage>> continuation) {
        return null;
    }
    
    public final int userId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object userId1(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.data.ReviewAndImage>> getMyReviews1(int restaurantId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMyReviews3(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.data.MyReview>> continuation) {
        return null;
    }
}