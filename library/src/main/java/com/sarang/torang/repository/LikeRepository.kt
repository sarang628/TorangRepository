package com.sarang.torang.repository

import com.sarang.torang.data.remote.response.RemoteFollower

interface LikeRepository {
    suspend fun getLikeUser(reviewId: Int): List<RemoteFollower>
}