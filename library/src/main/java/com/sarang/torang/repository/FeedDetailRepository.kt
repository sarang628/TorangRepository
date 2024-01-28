package com.sarang.torang.repository

import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.RemoteComment
import com.sarang.torang.data.entity.CommentEntity
import com.sarang.torang.data.entity.FeedEntity
import kotlinx.coroutines.flow.Flow

interface FeedDetailRepository : LoginCheckableRepository {
    suspend fun getComments(reviewId: Int): List<RemoteComment>
    fun getReview(): Flow<FeedEntity>
    fun getRestaurant(reviewId: Int): Flow<Restaurant>
    fun getFeed(reviewId: Int): Flow<FeedEntity>
    suspend fun addComment(reviewId: Int, value: String) : RemoteComment
    fun getCommentsFlow(reviewId: Int) : Flow<List<CommentEntity>>
}