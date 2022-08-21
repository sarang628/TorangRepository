package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/torangrepository/EditProfileRepositoryImpl;", "Lcom/example/torang_core/repository/EditProfileRepository;", "context", "Landroid/content/Context;", "restaurantService", "Lcom/example/torangrepository/services/RestaurantService;", "loggedInUserDao", "Lcom/example/torang_core/data/dao/LoggedInUserDao;", "userDao", "Lcom/example/torang_core/data/dao/UserDao;", "(Landroid/content/Context;Lcom/example/torangrepository/services/RestaurantService;Lcom/example/torang_core/data/dao/LoggedInUserDao;Lcom/example/torang_core/data/dao/UserDao;)V", "editProfile", "Lcom/example/torang_core/repository/EditProfileResponse;", "name", "", "uri", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Landroidx/lifecycle/LiveData;", "Lcom/example/torang_core/data/model/LoggedInUserData;", "library_debug"})
@javax.inject.Singleton()
public final class EditProfileRepositoryImpl implements com.example.torang_core.repository.EditProfileRepository {
    private final android.content.Context context = null;
    private final com.example.torangrepository.services.RestaurantService restaurantService = null;
    private final com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao = null;
    private final com.example.torang_core.data.dao.UserDao userDao = null;
    
    @javax.inject.Inject()
    public EditProfileRepositoryImpl(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.services.RestaurantService restaurantService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.LoggedInUserDao loggedInUserDao, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.UserDao userDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object editProfile(@org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String uri, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.repository.EditProfileResponse> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<com.example.torang_core.data.model.LoggedInUserData> getUser() {
        return null;
    }
}