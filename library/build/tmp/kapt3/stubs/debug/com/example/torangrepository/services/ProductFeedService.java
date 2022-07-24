package com.example.torangrepository.services;

import java.lang.System;

/**
 * 실서버 신고 서비스
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/torangrepository/services/ProductFeedService;", "", "torangOkHttpClientImpl", "Lcom/example/torangrepository/modules/TorangOkhttpClient;", "retrofitModule", "Lcom/example/torangrepository/modules/RetrofitModule;", "(Lcom/example/torangrepository/modules/TorangOkhttpClient;Lcom/example/torangrepository/modules/RetrofitModule;)V", "url", "", "create", "Lcom/example/torangrepository/services/FeedServices;", "library_debug"})
@javax.inject.Singleton()
public final class ProductFeedService {
    private final com.example.torangrepository.modules.TorangOkhttpClient torangOkHttpClientImpl = null;
    private final com.example.torangrepository.modules.RetrofitModule retrofitModule = null;
    private java.lang.String url = "https://www.vrscoo.com:8080/";
    
    @javax.inject.Inject()
    public ProductFeedService(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.modules.TorangOkhttpClient torangOkHttpClientImpl, @org.jetbrains.annotations.NotNull()
    com.example.torangrepository.modules.RetrofitModule retrofitModule) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.torangrepository.services.FeedServices create() {
        return null;
    }
}