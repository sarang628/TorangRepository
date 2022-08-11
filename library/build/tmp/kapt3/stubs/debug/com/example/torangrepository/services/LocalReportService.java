package com.example.torangrepository.services;

import java.lang.System;

/**
 * 로컬 서버 신고 서비스
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/example/torangrepository/services/LocalReportService;", "", "()V", "API_URL", "", "getAPI_URL", "()Ljava/lang/String;", "setAPI_URL", "(Ljava/lang/String;)V", "create", "Lcom/example/torangrepository/services/ReportService;", "context", "Landroid/content/Context;", "getHttpClient", "Lokhttp3/OkHttpClient;", "getRetrofit", "Lretrofit2/Retrofit;", "httpClient", "library_debug"})
public final class LocalReportService {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String API_URL = "http://10.0.2.2:8080/";
    
    public LocalReportService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAPI_URL() {
        return null;
    }
    
    public final void setAPI_URL(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final okhttp3.OkHttpClient getHttpClient(android.content.Context context) {
        return null;
    }
    
    private final retrofit2.Retrofit getRetrofit(okhttp3.OkHttpClient httpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.torangrepository.services.ReportService create(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}