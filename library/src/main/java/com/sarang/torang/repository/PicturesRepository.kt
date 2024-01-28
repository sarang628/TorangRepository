package com.sarang.torang.repository

import android.graphics.Picture
import com.sarang.torang.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): ArrayList<Picture>
    fun getFeedPicture(reviewId: Int): Flow<List<ReviewImageEntity>>
}