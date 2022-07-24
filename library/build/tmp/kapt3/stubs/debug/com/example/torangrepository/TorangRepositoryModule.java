package com.example.torangrepository;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\r"}, d2 = {"Lcom/example/torangrepository/TorangRepositoryModule;", "", "()V", "provideInfoRepository", "Lcom/example/torang_core/repository/InfoRepository;", "torangRepository", "Lcom/example/torangrepository/TorangRepository;", "provideMapRepository", "Lcom/example/torang_core/repository/MapRepository;", "provideMenuRepository", "Lcom/example/torang_core/repository/MenuRepository;", "provideReviewRepository", "Lcom/example/torang_core/repository/ReviewRepository;", "library_debug"})
@dagger.Module()
public abstract class TorangRepositoryModule {
    
    public TorangRepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.torang_core.repository.InfoRepository provideInfoRepository(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.TorangRepository torangRepository);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.torang_core.repository.ReviewRepository provideReviewRepository(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.TorangRepository torangRepository);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.torang_core.repository.MenuRepository provideMenuRepository(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.TorangRepository torangRepository);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract com.example.torang_core.repository.MapRepository provideMapRepository(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.TorangRepository torangRepository);
}