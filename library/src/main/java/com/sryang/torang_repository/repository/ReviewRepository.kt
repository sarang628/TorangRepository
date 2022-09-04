package com.sryang.torang_repository.repository

import com.sryang.torang_core.data.entity.Review

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int) : ArrayList<Review>
}