package com.sryang.torang_repository.repository

import android.graphics.Picture
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.StateFlow

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): ArrayList<Picture>
    fun getFeedPicture(reviewId: Int): StateFlow<List<ReviewImageEntity>>
}