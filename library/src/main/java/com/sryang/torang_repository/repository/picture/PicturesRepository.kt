package com.sryang.torang_repository.repository.picture

import android.graphics.Picture
import com.sryang.torang_repository.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): ArrayList<Picture>
    fun getFeedPicture(reviewId: Int): Flow<List<ReviewImageEntity>>
}