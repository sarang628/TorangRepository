package com.sarang.torang.repository

import com.sarang.torang.core.database.model.comment.CommentEntity
import com.sarang.torang.core.database.model.feed.FeedEntity
import com.sarang.torang.data.Restaurant
import com.sarang.torang.data.remote.response.RemoteComment
import kotlinx.coroutines.flow.Flow

interface FeedDetailRepository  {
    suspend fun getComments(reviewId: Int): List<RemoteComment>
    fun getReview(): Flow<FeedEntity>
    fun getRestaurant(reviewId: Int): Flow<Restaurant>
    fun getFeed(reviewId: Int): Flow<FeedEntity>
    suspend fun addComment(reviewId: Int, value: String) : RemoteComment
    fun getCommentsFlow(reviewId: Int) : Flow<List<CommentEntity>>
}