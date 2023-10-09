package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.RemoteComment
import com.sryang.torang_repository.data.entity.CommentEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.repository.login.LoginCheckableRepository
import kotlinx.coroutines.flow.Flow

interface TimeLineDetailRepository : LoginCheckableRepository {
    suspend fun getComments(reviewId: Int): List<RemoteComment>
    fun getReview(): Flow<FeedEntity>
    fun getRestaurant(reviewId: Int): Flow<Restaurant>
    fun getFeed(reviewId: Int): Flow<FeedEntity>
    suspend fun addComment(reviewId: Int, value: String) : RemoteComment
    fun getCommentsFlow(reviewId: Int) : Flow<List<CommentEntity>>
}