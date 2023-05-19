package com.sryang.torang_repository.repository

import android.graphics.Picture
import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.entity.ReviewImageEntity

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): ArrayList<Picture>
    fun getFeedPicture(reviewId: Int): LiveData<List<ReviewImageEntity>>
}