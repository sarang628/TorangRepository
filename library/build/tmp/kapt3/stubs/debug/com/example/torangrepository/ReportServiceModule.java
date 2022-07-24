package com.example.torangrepository;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/example/torangrepository/ReportServiceModule;", "", "()V", "provideReportService", "Lcom/example/torangrepository/ReportService;", "productReportService", "Lcom/example/torangrepository/ProductReportService;", "library_debug"})
@dagger.Module()
public final class ReportServiceModule {
    
    public ReportServiceModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.torangrepository.ReportService provideReportService(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.ProductReportService productReportService) {
        return null;
    }
}