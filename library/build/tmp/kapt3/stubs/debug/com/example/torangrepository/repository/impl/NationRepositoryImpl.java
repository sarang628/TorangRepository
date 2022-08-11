package com.example.torangrepository.repository.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010\b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/torangrepository/repository/impl/NationRepositoryImpl;", "Lcom/example/torang_core/repository/NationRepository;", "Lcom/example/torangrepository/MapSharedRepositoryImpl;", "restaurantDao", "Lcom/example/torang_core/data/dao/RestaurantDao;", "restaurantService", "Lcom/example/torangrepository/services/RestaurantService;", "(Lcom/example/torang_core/data/dao/RestaurantDao;Lcom/example/torangrepository/services/RestaurantService;)V", "selectNationItem", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/torang_core/data/NationItem;", "findRestaurant", "", "Lcom/example/torang_core/data/model/Restaurant;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNationItems", "getSelectNationItem", "Lkotlinx/coroutines/flow/StateFlow;", "", "nationItem", "(Lcom/example/torang_core/data/NationItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class NationRepositoryImpl extends com.example.torangrepository.MapSharedRepositoryImpl implements com.example.torang_core.repository.NationRepository {
    private final com.example.torang_core.data.dao.RestaurantDao restaurantDao = null;
    private final com.example.torangrepository.services.RestaurantService restaurantService = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.torang_core.data.NationItem> selectNationItem = null;
    
    @javax.inject.Inject()
    public NationRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.RestaurantDao restaurantDao, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.services.RestaurantService restaurantService) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getNationItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.NationItem>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object findRestaurant(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.torang_core.data.model.Restaurant>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.StateFlow<com.example.torang_core.data.NationItem> getSelectNationItem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object selectNationItem(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.NationItem nationItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}