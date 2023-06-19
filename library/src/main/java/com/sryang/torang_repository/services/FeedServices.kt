package com.sryang.torang_repository.services

import com.sryang.torang_repository.data.Favorite
import com.sryang.torang_repository.data.Like
import com.sryang.torang_repository.data.Review
import com.sryang.torang_repository.data.entity.ReviewDeleteRequestVO
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FeedServices {
    @FormUrlEncoded
    @POST("getFeeds")
    suspend fun getFeeds(@FieldMap params: Map<String, String>): List<RemoteFeed>

    @POST("deleteReview")
    suspend fun deleteReview(@Body review: ReviewDeleteRequestVO): Review

    @POST("addLike")
    suspend fun addLike(@Body like: Like): Like

    @POST("deleteLike")
    suspend fun deleteLike(@Body like: Like): Like

    @POST("deleteFavorite")
    suspend fun deleteFavorite(@Body favorite: Favorite): Favorite

    @POST("addFavorite")
    suspend fun addFavorite(@Body favorite: Favorite): Favorite
}