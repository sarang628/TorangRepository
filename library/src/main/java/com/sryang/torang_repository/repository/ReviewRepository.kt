package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.RemoteReview

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int) : ArrayList<RemoteReview>
}