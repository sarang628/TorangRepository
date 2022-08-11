package com.example.torangrepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/torangrepository/ReportRepositoryImpl;", "Lcom/example/torang_core/repository/ReportRepository;", "reportService", "Lcom/example/torangrepository/services/ReportService;", "feedDao", "Lcom/example/torang_core/data/dao/FeedDao;", "(Lcom/example/torangrepository/services/ReportService;Lcom/example/torang_core/data/dao/FeedDao;)V", "hasFeed", "", "reviewId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendReportAfterSupport", "reportAfterSupport", "Lcom/example/torang_core/repository/ReportAfterSupport;", "(Lcom/example/torang_core/repository/ReportAfterSupport;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendReportReason", "reportReason", "Lcom/example/torang_core/repository/ReportReason;", "(Lcom/example/torang_core/repository/ReportReason;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_debug"})
@javax.inject.Singleton()
public final class ReportRepositoryImpl implements com.example.torang_core.repository.ReportRepository {
    private final com.example.torangrepository.services.ReportService reportService = null;
    private final com.example.torang_core.data.dao.FeedDao feedDao = null;
    
    @javax.inject.Inject()
    public ReportRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.torangrepository.services.ReportService reportService, @org.jetbrains.annotations.NotNull()
    com.example.torang_core.data.dao.FeedDao feedDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object sendReportReason(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.ReportReason reportReason, int reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object sendReportAfterSupport(@org.jetbrains.annotations.NotNull()
    com.example.torang_core.repository.ReportAfterSupport reportAfterSupport, int reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object hasFeed(int reviewId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}