package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.remote.response.RemoteFeed

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int) : List<RemoteFeed>
}