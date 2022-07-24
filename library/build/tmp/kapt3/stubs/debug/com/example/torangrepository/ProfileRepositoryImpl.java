package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\nH\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\nH\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00150\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0011\u0010\t\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\"\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\n2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0011\u0010%\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0013\u0010&\u001a\u0004\u0018\u00010\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/torangrepository/ProfileRepositoryImpl;", "Lcom/example/torang_core/repository/ProfileRepository;", "loggedUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "userDao", "Lcom/example/torang_core/data/dao/UserDao;", "feedDao", "Lcom/example/torang_core/data/dao/FeedDao;", "(Lcom/example/torang_core/data/dao/LoggedInUserDao;Lcom/example/torang_core/data/dao/UserDao;Lcom/example/torang_core/data/dao/FeedDao;)V", "isLogin", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "favorite", "", "reviewId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorite", "Lcom/example/torang_core/data/model/Favorite;", "getFeed", "", "Lcom/example/torang_core/data/model/Feed;", "getLike", "Lcom/example/torang_core/data/model/Like;", "getMyFavorite", "userId", "getMyFeed", "getMyProfile", "Lcom/example/torang_core/data/model/LoggedInUserData;", "getReviewImages", "Lcom/example/torang_core/data/model/ReviewImage;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "like", "loadFeed", "loadProfile", "Lcom/example/torang_core/data/model/UserData;", "logout", "user1", "library_debug"})
@javax.inject.Singleton()
public final class ProfileRepositoryImpl implements com.example.torang_core.repository.ProfileRepository {
    private final com.example.torang_core.data.dao.LoggedInUserDao loggedUserDao = null;
    private final com.example.torang_core.data.dao.UserDao userDao = null;
    private final com.example.torang_core.data.dao.FeedDao feedDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLogin = null;
    
    @javax.inject.Inject()
    public ProfileRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao loggedUserDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.FeedDao feedDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.LoggedInUserData> getMyProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.UserData> loadProfile(int userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.Feed>> getMyFeed(int userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.Feed>> getMyFavorite(int userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.Feed>> getFeed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadFeed(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object like(int reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object favorite(int reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.Like> getLike(int reviewId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.Favorite> getFavorite(int reviewId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object user1(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.LoggedInUserData> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.lang.Boolean> isLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object isLogin(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.ReviewImage>> getReviewImages(int reviewId) {
        return null;
    }
}