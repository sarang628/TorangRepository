package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J)\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/torangrepository/PicturesRepositoryImpl;", "Lcom/example/torang_core/repository/PicturesRepository;", "restaurantService", "Lcom/example/torangrepository/RestaurantService;", "pictureDao", "Lcom/example/torang_core/data/dao/PictureDao;", "(Lcom/example/torangrepository/RestaurantService;Lcom/example/torang_core/data/dao/PictureDao;)V", "getFeedPicture", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/torang_core/data/model/ReviewImage;", "reviewId", "", "getPictures", "Ljava/util/ArrayList;", "Lcom/example/torang_core/data/model/Picture;", "Lkotlin/collections/ArrayList;", "restaurantId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class PicturesRepositoryImpl implements com.example.torang_core.repository.PicturesRepository {
    private final com.example.torangrepository.RestaurantService restaurantService = null;
    private final com.example.torang_core.data.dao.PictureDao pictureDao = null;
    
    @javax.inject.Inject()
    public PicturesRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.RestaurantService restaurantService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.PictureDao pictureDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPictures(int restaurantId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Picture>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.torang_core.data.model.ReviewImage>> getFeedPicture(int reviewId) {
        return null;
    }
}