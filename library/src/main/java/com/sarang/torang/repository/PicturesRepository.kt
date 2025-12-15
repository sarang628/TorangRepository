package com.sarang.torang.repository

import com.sarang.torang.data.Picture
import com.sarang.torang.data.ReviewImage
import kotlinx.coroutines.flow.Flow

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): List<Picture>
    fun getFeedPictureFlow(reviewId: Int): Flow<List<ReviewImage>>
    suspend fun getFeedPicture(reviewId: Int): List<ReviewImage>
    suspend fun getImagesByRestaurantId(restaurantId: Int): List<ReviewImage>
    suspend fun getImagesByImageId(imageId: Int): List<ReviewImage>
}