package com.sarang.torang.repository.feed

import com.sarang.torang.data.Comment
import com.sarang.torang.data.Feed
import com.sarang.torang.data.Restaurant
import kotlinx.coroutines.flow.Flow

interface FeedDetailRepository  {
    suspend fun getComments(reviewId: Int): List<Comment>
    fun getReview(): Flow<Feed>
    fun getRestaurant(reviewId: Int): Flow<Restaurant>
    fun getFeed(reviewId: Int): Flow<Feed>
    suspend fun addComment(reviewId: Int, value: String) : Comment
    fun getCommentsFlow(reviewId: Int) : Flow<List<Comment>>
}