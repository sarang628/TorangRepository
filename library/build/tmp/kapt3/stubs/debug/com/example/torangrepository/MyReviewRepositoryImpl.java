package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\"\u001a\u00020\u0013H\u0016J\u0011\u0010#\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/example/torangrepository/MyReviewRepositoryImpl;", "Lcom/example/torang_core/repository/MyReviewRepository;", "context", "Landroid/content/Context;", "reviewDao", "Lcom/example/torang_core/data/dao/ReviewDao;", "restaurantService", "Lcom/example/torangrepository/RestaurantService;", "userDao", "Lcom/example/torang_core/data/dao/UserDao;", "restaurantDao", "Lcom/example/torang_core/data/dao/RestaurantDao;", "loggedInUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "(Landroid/content/Context;Lcom/example/torang_core/data/dao/ReviewDao;Lcom/example/torangrepository/RestaurantService;Lcom/example/torang_core/data/dao/UserDao;Lcom/example/torang_core/data/dao/RestaurantDao;Lcom/example/torang_core/data/dao/LoggedInUserDao;)V", "getMyReview", "Landroidx/lifecycle/LiveData;", "Lcom/example/torang_core/data/data/ReviewAndImage;", "reviewId", "", "getRestaurant", "Lcom/example/torang_core/data/model/RestaurantData;", "restaurantId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUploadedPicture", "", "Lcom/example/torang_core/data/model/ReviewImage;", "modifyReview", "", "review", "(Lcom/example/torang_core/data/data/ReviewAndImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/example/torang_core/data/model/ModifyFeedData;", "(Lcom/example/torang_core/data/model/ModifyFeedData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadReview", "userId", "userId1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class MyReviewRepositoryImpl implements com.example.torang_core.repository.MyReviewRepository {
    private final android.content.Context context = null;
    private final com.example.torang_core.data.dao.ReviewDao reviewDao = null;
    private final com.example.torangrepository.RestaurantService restaurantService = null;
    private final com.example.torang_core.data.dao.UserDao userDao = null;
    private final com.example.torang_core.data.dao.RestaurantDao restaurantDao = null;
    private final com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao = null;
    
    @javax.inject.Inject()
    public MyReviewRepositoryImpl(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.ReviewDao reviewDao, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.RestaurantService restaurantService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.RestaurantDao restaurantDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.data.ReviewAndImage> getMyReview(int reviewId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.ReviewImage>> getUploadedPicture(int reviewId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object uploadReview(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.data.ReviewAndImage review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object modifyReview(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.data.ReviewAndImage review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object modifyReview(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.ModifyFeedData review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getRestaurant(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.RestaurantData> continuation) {
        return null;
    }
    
    @java.lang.Override()
    public int userId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object userId1(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
}