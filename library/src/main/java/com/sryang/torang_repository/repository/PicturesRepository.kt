package com.sryang.torang_repository.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_core.data.entity.Picture
import com.sryang.torang_repository.data.entity.ReviewImageEntity

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): ArrayList<Picture>
    fun getFeedPicture(reviewId: Int): LiveData<List<ReviewImageEntity>>
}