package com.example.torangrepository.repository.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0011\u0010\b\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/torangrepository/repository/impl/FilterRepositoryImpl;", "Lcom/example/torang_core/repository/FilterRepository;", "()V", "filter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/torang_core/data/model/Filter;", "getCurrentFilter", "Lkotlinx/coroutines/flow/StateFlow;", "getFilter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectDistance", "", "distances", "Lcom/example/torang_core/data/model/Distances;", "(Lcom/example/torang_core/data/model/Distances;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectPrice", "price", "Lcom/example/torang_core/data/model/Prices;", "(Lcom/example/torang_core/data/model/Prices;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectRatings", "ratings", "Lcom/example/torang_core/data/model/Ratings;", "(Lcom/example/torang_core/data/model/Ratings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectRestaurantType", "food", "Lcom/example/torang_core/data/model/RestaurantType;", "(Lcom/example/torang_core/data/model/RestaurantType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class FilterRepositoryImpl implements com.example.torang_core.repository.FilterRepository {
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.torang_core.data.model.Filter> filter = null;
    
    @javax.inject.Inject()
    public FilterRepositoryImpl() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.StateFlow<com.example.torang_core.data.model.Filter> getCurrentFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object selectRestaurantType(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.RestaurantType food, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object selectPrice(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Prices price, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object selectRatings(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Ratings ratings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object selectDistance(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.model.Distances distances, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getFilter(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Filter> continuation) {
        return null;
    }
}