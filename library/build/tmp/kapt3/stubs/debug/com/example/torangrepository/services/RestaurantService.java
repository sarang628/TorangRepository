package com.example.torangrepository.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00142\b\b\u0001\u0010!\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J!\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\b\u0001\u0010%\u001a\u00020\u001eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&JG\u0010\'\u001a\u00020\u00142$\b\u0001\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)`*2\u000e\b\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.J!\u0010/\u001a\b\u0012\u0004\u0012\u0002000,2\b\b\u0001\u00101\u001a\u000202H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J-\u00104\u001a\b\u0012\u0004\u0012\u0002050,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ!\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030,2\b\b\u0001\u00107\u001a\u00020\u001eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J-\u00108\u001a\b\u0012\u0004\u0012\u0002090,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ!\u0010:\u001a\b\u0012\u0004\u0012\u0002050,2\b\b\u0001\u0010;\u001a\u00020<H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J-\u0010>\u001a\b\u0012\u0004\u0012\u00020?0,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ3\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,0\u000f2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ-\u0010A\u001a\b\u0012\u0004\u0012\u00020B0,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\'\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,0\u000f2\b\b\u0001\u0010!\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J-\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ-\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00140,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ3\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140,0\u000f2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ-\u0010G\u001a\b\u0012\u0004\u0012\u00020H0,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\'\u0010I\u001a\u0002052\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ-\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00140,2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ3\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140,0\u000f2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ!\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J-\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f2\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJM\u0010N\u001a\b\u0012\u0004\u0012\u00020$0#2$\b\u0001\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)`*2\u000e\b\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.J!\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016JG\u0010O\u001a\u00020\u00142$\b\u0001\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020)`*2\u000e\b\u0001\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006P"}, d2 = {"Lcom/example/torangrepository/services/RestaurantService;", "", "addComment", "Lcom/example/torang_core/data/model/Comment;", "comment", "(Lcom/example/torang_core/data/model/Comment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFavorite", "Lcom/example/torang_core/data/model/Favorite;", "favorite", "(Lcom/example/torang_core/data/model/Favorite;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLike", "Lcom/example/torang_core/data/model/Like;", "like", "(Lcom/example/torang_core/data/model/Like;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMenuReview", "Lretrofit2/Call;", "Lcom/example/torang_core/data/model/MenuReview;", "menuReview", "(Lcom/example/torang_core/data/model/MenuReview;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addReview", "Lcom/example/torang_core/data/model/Review;", "reviewBody", "(Lcom/example/torang_core/data/model/Review;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "deleteFavorite", "deleteLike", "deletePicture", "Ljava/lang/Void;", "params", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReview", "review", "facebook_login", "Lcom/example/torang_core/data/model/Response;", "Lcom/example/torang_core/data/model/User;", "accessToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileUpload", "Ljava/util/HashMap;", "Lokhttp3/RequestBody;", "Lkotlin/collections/HashMap;", "pictures", "Ljava/util/ArrayList;", "Lokhttp3/MultipartBody$Part;", "(Ljava/util/HashMap;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarms", "Lcom/example/torang_core/data/model/Alarm;", "user_id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRestaurant", "Lcom/example/torang_core/data/model/Restaurant;", "getComments", "review_id", "getFeeds", "Lcom/example/torang_core/data/model/FeedResponse;", "getFilterRestaurant", "filter", "Lcom/example/torang_core/data/model/Filter;", "(Lcom/example/torang_core/data/model/Filter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHoursOfOperation", "Lcom/example/torang_core/data/model/HoursOfOperation;", "getMenuReviews", "getMenus", "Lcom/example/torang_core/data/model/Menu;", "getMyMenuReviews", "getMyReview", "getMyReviews", "getMyReviewsByUserId", "getPictures", "Lcom/example/torang_core/data/model/Picture;", "getRestaurant", "getReviews", "getTimelines", "modifyComment", "saveMenu", "updateProfile", "updateReview", "library_debug"})
public abstract interface RestaurantService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getAllRestaurant")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getAllRestaurant(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Restaurant>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getFilterRestaurant")
    public abstract java.lang.Object getFilterRestaurant(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Filter filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Restaurant>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getRestaurant")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getRestaurant(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Restaurant> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getOpenHours")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getHoursOfOperation(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.HoursOfOperation>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getMenus")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getMenus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Menu>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getPictures")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getPictures(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Picture>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addReview")
    public abstract java.lang.Object addReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Review reviewBody, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<com.example.torang_core.data.model.Review>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "updateReview")
    public abstract java.lang.Object updateReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Review reviewBody, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<com.example.torang_core.data.model.Review>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteReview")
    public abstract java.lang.Object deleteReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Review review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Review> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getReviews")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getReviews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Review>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getMyReview")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getMyReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<com.example.torang_core.data.model.Review>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getMenuReviews")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getMenuReviews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.util.ArrayList<com.example.torang_core.data.model.MenuReview>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "facebook_login")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object facebook_login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "accessToken")
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Response<com.example.torang_core.data.model.User>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "fileUpload")
    @retrofit2.http.Multipart()
    public abstract java.lang.Object fileUpload(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.HashMap<java.lang.String, okhttp3.RequestBody> params, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    java.util.ArrayList<okhttp3.MultipartBody.Part> pictures, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Review> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "updateReview")
    @retrofit2.http.Multipart()
    public abstract java.lang.Object updateReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.HashMap<java.lang.String, okhttp3.RequestBody> params, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    java.util.ArrayList<okhttp3.MultipartBody.Part> pictures, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Review> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deletePicture")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object deletePicture(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.lang.Void>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getTimelines")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getTimelines(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.util.ArrayList<com.example.torang_core.data.model.Review>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "saveMenu")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object saveMenu(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.lang.Void>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getFeeds")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getFeeds(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.FeedResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addMenuReview")
    public abstract java.lang.Object addMenuReview(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.MenuReview menuReview, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<com.example.torang_core.data.model.MenuReview>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getMyReviews")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getMyReviews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Review>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getMyReviewsByUserId")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getMyReviewsByUserId(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.String> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.util.ArrayList<com.example.torang_core.data.model.Review>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getMyMenuReviews")
    public abstract java.lang.Object getMyMenuReviews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Review review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<java.util.ArrayList<com.example.torang_core.data.model.MenuReview>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addComment")
    public abstract java.lang.Object addComment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Comment> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "modifyComment")
    public abstract java.lang.Object modifyComment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<com.example.torang_core.data.model.Comment>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteComment")
    public abstract java.lang.Object deleteComment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Comment comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Call<com.example.torang_core.data.model.Comment>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getComments")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getComments(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "review_id")
    java.lang.String review_id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Comment>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addLike")
    public abstract java.lang.Object addLike(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Like like, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Like> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteLike")
    public abstract java.lang.Object deleteLike(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Like like, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Like> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "getAlarms")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object getAlarms(@retrofit2.http.Field(value = "user_id")
    int user_id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.torang_core.data.model.Alarm>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "updateProfile")
    @retrofit2.http.Multipart()
    public abstract java.lang.Object updateProfile(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.PartMap()
    java.util.HashMap<java.lang.String, okhttp3.RequestBody> params, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    java.util.ArrayList<okhttp3.MultipartBody.Part> pictures, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Response<com.example.torang_core.data.model.User>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "deleteFavorite")
    public abstract java.lang.Object deleteFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Favorite favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Favorite> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "addFavorite")
    public abstract java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.torang_core.data.model.Favorite favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.torang_core.data.model.Favorite> continuation);
}