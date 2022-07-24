package com.example.torangrepository.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/torangrepository/services/FeedServices;", "", "addFavorite", "Lcom/example/torang_core/data/model/Favorite;", "favorite", "(Lcom/example/torang_core/data/model/Favorite;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLike", "Lcom/example/torang_core/data/model/Like;", "like", "(Lcom/example/torang_core/data/model/Like;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavorite", "deleteLike", "deleteReview", "Lcom/example/torang_core/data/model/Review;", "review", "(Lcom/example/torang_core/data/model/Review;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeeds", "Ljava/util/ArrayList;", "Lcom/example/torang_core/data/model/FeedResponse;", "params", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
public abstract interface FeedServices {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getFeeds")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getFeeds(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.FeedResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteReview")
    public abstract java.lang.Object deleteReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Review review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Review> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addLike")
    public abstract java.lang.Object addLike(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Like like, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Like> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteLike")
    public abstract java.lang.Object deleteLike(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Like like, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Like> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteFavorite")
    public abstract java.lang.Object deleteFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Favorite favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Favorite> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addFavorite")
    public abstract java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Favorite favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Favorite> continuation);
}