package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.Restaurant
import com.sryang.torang_repository.data.Comment
import com.sryang.torang_repository.data.entity.CommentEntity
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.repository.login.LoginCheckableRepository
import kotlinx.coroutines.flow.Flow

interface TimeLineDetailRepository : LoginCheckableRepository {
    suspend fun getComments(reviewId: String): ArrayList<Comment>
    fun getReview(): Flow<FeedEntity>
    fun getRestaurant(reviewId: Int): Flow<Restaurant>
    fun getFeed(reviewId: Int): Flow<FeedEntity>
    suspend fun addComment(reviewId: Int, value: String) : Comment
    fun getComments(reviewId: Int) : Flow<List<CommentEntity>>
}