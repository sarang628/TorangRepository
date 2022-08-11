package com.example.torangrepository.repository.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/torangrepository/repository/impl/FeedRepositoryImpl;", "Lcom/example/torang_core/repository/FeedRepository;", "context", "Landroid/content/Context;", "feedServices", "Lcom/example/torangrepository/services/FeedServices;", "userDao", "Lcom/example/torang_core/data/dao/UserDao;", "user", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "(Landroid/content/Context;Lcom/example/torangrepository/services/FeedServices;Lcom/example/torang_core/data/dao/UserDao;Lcom/example/torang_core/data/dao/LoggedInUserDao;)V", "deleteFeed", "", "reviewId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeed", "Ljava/util/ArrayList;", "Lcom/example/torang_core/data/remote/RemoteFeed;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userId", "library_debug"})
@javax.inject.Singleton()
public final class FeedRepositoryImpl implements com.example.torang_core.repository.FeedRepository {
    private final android.content.Context context = null;
    private final com.example.torangrepository.services.FeedServices feedServices = null;
    private final com.example.torang_core.data.dao.UserDao userDao = null;
    private final com.example.torang_core.data.dao.LoggedInUserDao user = null;
    
    @javax.inject.Inject()
    public FeedRepositoryImpl(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.services.FeedServices feedServices, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao user) {
        super();
    }
    
    public final int userId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteFeed(int reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object loadFeed(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.remote.RemoteFeed>> continuation) {
        return null;
    }
}