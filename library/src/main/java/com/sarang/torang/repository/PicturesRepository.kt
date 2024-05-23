package com.sarang.torang.repository

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text2.BasicTextField2
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
import com.sarang.torang.Picture
import com.sarang.torang.data.entity.ReviewImageEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): List<Picture>
    fun getFeedPictureFlow(reviewId: Int): Flow<List<ReviewImageEntity>>
    suspend fun getFeedPicture(reviewId: Int): List<ReviewImageEntity>
    suspend fun getImagesByRestaurantId(restaurantId: Int): List<ReviewImageEntity>
}

@Composable
fun PicturesRepositoryTest(repository: PicturesRepository) {
    val coroutine = rememberCoroutineScope()
    var result by remember { mutableStateOf("") }
    var list: List<ReviewImageEntity>? by remember { mutableStateOf(ArrayList()) }
    var list1: List<ReviewImageEntity>? by remember { mutableStateOf(ArrayList()) }
    PicturesRepositoryTest(
        onRestaurant = {
            coroutine.launch {
                try {
                    list = repository.getImagesByRestaurantId(it.toInt())
                    list1 = null
                    result =
                        GsonBuilder().setPrettyPrinting().create().toJson(list)
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        },
        onReview = {
            coroutine.launch {
                try {
                    repository.getFeedPictureFlow(reviewId = it.toInt()).collect {
                        list = null
                        list1 = it
                        result =
                            GsonBuilder().setPrettyPrinting().create().toJson(list1)
                    }
                } catch (e: Exception) {
                    result = e.toString()
                }
            }
        },
        result = result,
        list = list,
        list1 = list1
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun PicturesRepositoryTest(
    onRestaurant: (String) -> Unit,
    onReview: (String) -> Unit,
    result: String,
    list: List<ReviewImageEntity>? = null,
    list1: List<ReviewImageEntity>? = null,
) {
    val REVIEW_IMAGE_SERVER_URL = "http://sarang628.iptime.org:89/review_images/"
    var restaurantId by remember { mutableStateOf("1") }
    var reviewId by remember { mutableStateOf("1") }
    Column(modifier = Modifier.fillMaxSize()) {
        InputChip(selected = true, onClick = { onRestaurant.invoke(restaurantId) }, label = {
            Text(text = "getPictures restaurantId:")
            BasicTextField2(value = "$restaurantId", onValueChange = { restaurantId = it })
        })

        InputChip(selected = true, onClick = { onReview.invoke(reviewId) }, label = {
            Text(text = "getPictures reviewId:")
            BasicTextField2(value = "$reviewId", onValueChange = { reviewId = it })
        })

        list?.let {
            LazyColumn(modifier = Modifier.size(300.dp)) {
                items(it.size) {
                    AsyncImage(
                        model = REVIEW_IMAGE_SERVER_URL + list[it].pictureUrl,
                        contentDescription = null,
                    )
                }
            }
        }

        list1?.let {
            LazyColumn(modifier = Modifier.size(300.dp)) {
                items(it.size) {
                    AsyncImage(
                        model = REVIEW_IMAGE_SERVER_URL + list1[it].pictureUrl,
                        contentDescription = null,
                    )
                }
            }
        }

        Text(text = result)
    }
}

@Preview
@Composable
fun PreviewPicturesRepositoryTest() {
    PicturesRepositoryTest(onRestaurant = {}, result = "", list = null, list1 = null, onReview = {})
}