package com.sryang.torang_repository.repository

import com.sryang.torang_repository.Restaurant
import com.sryang.torang_repository.data.Comment
import com.sryang.torang_repository.data.Feed
import com.sryang.torang_repository.data.entity.CommentEntity
import kotlinx.coroutines.flow.StateFlow

interface TimeLineDetailRepository : LoginCheckableRepository {
    suspend fun getComments(reviewId: String): ArrayList<Comment>
    fun getReview(): StateFlow<Feed>
    fun getRestaurant(reviewId: Int): StateFlow<Restaurant>
    fun getFeed(reviewId: Int): StateFlow<Feed>
    suspend fun addComment(reviewId: Int, value: String) : Comment
    fun getComments(reviewId: Int) : StateFlow<List<CommentEntity>>
}