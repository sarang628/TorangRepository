package com.sarang.torang.repository

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.gson.GsonBuilder
import com.sarang.torang.data.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import com.sarang.torang.core.database.model.image.ReviewImageEntity

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): List<Picture>
    fun getFeedPictureFlow(reviewId: Int): Flow<List<ReviewImageEntity>>
    suspend fun getFeedPicture(reviewId: Int): List<ReviewImageEntity>
    suspend fun getImagesByRestaurantId(restaurantId: Int): List<ReviewImageEntity>
    suspend fun getImagesByImageId(imageId: Int): List<ReviewImageEntity>
}