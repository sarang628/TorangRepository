package com.sryang.torang_repository.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_core.data.entity.Comment
import com.sryang.torang_core.data.entity.Restaurant
import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_repository.data.entity.CommentEntity

interface TimeLineDetailRepository : LoginCheckableRepository {
    suspend fun getComments(reviewId: String): ArrayList<Comment>
    fun getReview(): LiveData<Feed>
    fun getRestaurant(reviewId: Int): LiveData<Restaurant>
    fun getFeed(reviewId: Int): LiveData<Feed>
    suspend fun addComment(reviewId: Int, value: String) : Comment
    fun getComments(reviewId: Int) : LiveData<List<CommentEntity>>
}