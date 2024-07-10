package com.sarang.torang.repository

import com.sarang.torang.data.remote.response.FollowerApiModel

interface LikeRepository {
    suspend fun getLikeUser(reviewId: Int): List<FollowerApiModel>
}