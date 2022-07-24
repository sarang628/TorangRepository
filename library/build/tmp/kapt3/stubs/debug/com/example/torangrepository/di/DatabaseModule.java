package com.example.torangrepository.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/example/torangrepository/di/DatabaseModule;", "", "()V", "provideCommentDao", "Lcom/example/torang_core/data/dao/CommentDao;", "appDatabase", "Lcom/example/torang_core/data/AppDatabase;", "provideLoggedInUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "provideMyReviewDao", "Lcom/example/torang_core/data/dao/MyReviewDao;", "providePictureDao", "Lcom/example/torang_core/data/dao/PictureDao;", "provideRestaurantDao", "Lcom/example/torang_core/data/dao/RestaurantDao;", "provideReviewDao", "Lcom/example/torang_core/data/dao/ReviewDao;", "provideSearchDao", "Lcom/example/torang_core/data/dao/SearchDao;", "provideUserDao", "Lcom/example/torang_core/data/dao/UserDao;", "providefeedDao", "Lcom/example/torang_core/data/dao/FeedDao;", "library_debug"})
@dagger.Module()
public final class DatabaseModule {
    
    public DatabaseModule() {
        super();
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 로그인 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.LoggedInUserDao provideLoggedInUserDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.FeedDao providefeedDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.SearchDao provideSearchDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.CommentDao provideCommentDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.RestaurantDao provideRestaurantDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.ReviewDao provideReviewDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.MyReviewDao provideMyReviewDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
    
    /**
     * 로컬 데이터베이스의 사용자 관리 DAO 제공
     */
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.torang_core.data.dao.PictureDao providePictureDao(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.AppDatabase appDatabase) {
        return null;
    }
}