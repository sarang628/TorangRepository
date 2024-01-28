package com.sarang.torang.repository

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.GsonBuilder
import com.sarang.torang.data.entity.ReviewAndImageEntity
import com.sarang.torang.data.remote.response.RemoteFeed
import kotlinx.coroutines.launch

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int): List<RemoteFeed>

    suspend fun addReview(
        contents: String,
        restaurantId: Int,
        rating: Float,
        files: List<String>
    ): RemoteFeed

    suspend fun updateReview(
        reviewId: Int,
        contents: String,
        restaurantId: Int,
        rating: Float,
        files: List<String>,
        uploadedImage: List<Int>
    )

    suspend fun getReview(reviewId: Int): ReviewAndImageEntity
}

@Composable
fun ReviewRepositoryTest(
    reviewRepository: ReviewRepository, gallery: (@Composable (
        onNext: (List<String>) -> Unit
    ) -> Unit)? = null
) {
    Column {
        //AddReviewTest(reviewRepository = reviewRepository, gallery = gallery)
        //UpdateReviewTest(reviewRepository = reviewRepository, gallery = gallery)
        //GetReviewTest()
        DeleteReviewTest(reviewRepository = reviewRepository)
    }
}

@Composable
fun AddReviewTest(
    reviewRepository: ReviewRepository, gallery: (@Composable (
        onNext: (List<String>) -> Unit
    ) -> Unit)? = null
) {
    val coroutine = rememberCoroutineScope()
    var contents by remember { mutableStateOf("good!") }
    var rating by remember { mutableStateOf("3.5") }
    var files: List<String> by remember { mutableStateOf(ArrayList()) }
    var restaurantId by remember { mutableStateOf("10") }
    var deleteImageId by remember { mutableStateOf("10") }
    var reviewId by remember { mutableStateOf("10") }
    var result by remember { mutableStateOf("") }
    var uploadedImage: List<Int> by remember { mutableStateOf(ArrayList()) }
    val navHostController = rememberNavController()
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "AddReviewTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        NavHost(navController = navHostController, startDestination = "a") {
            composable("a") {
                Column {
                    Text(text = result)
                    OutlinedTextField(value = contents, onValueChange = { contents = it }, label = {
                        Text(
                            text = "contents"
                        )
                    })
                    Row {
                        OutlinedTextField(
                            value = reviewId,
                            onValueChange = { reviewId = it },
                            label = {
                                Text(text = "reviewId")
                            })
                        Button(onClick = {
                            coroutine.launch {
                                try {
                                    val row = reviewRepository.getReview(reviewId.toInt())
                                    uploadedImage = row.images.map { it.pictureId }
                                    contents = row.review.contents
                                    result = ""
                                } catch (e: Exception) {
                                    result = e.message.toString()
                                }
                            }

                        }) {
                            Text(text = "LoadReview")

                        }
                    }
                    OutlinedTextField(
                        value = restaurantId,
                        onValueChange = { restaurantId = it },
                        label = {
                            Text(text = "restaurantId")
                        })
                    OutlinedTextField(value = rating, onValueChange = { rating = it }, label = {
                        Text(text = "rating")
                    })
                    Text(text = "files : $files")
                    Text(text = "uploaded : $uploadedImage")
                    Row {
                        OutlinedTextField(
                            value = deleteImageId,
                            onValueChange = { deleteImageId = it },
                            label = {
                                Text(text = "deleteImageId")
                            })
                        Button(onClick = {
                            uploadedImage = uploadedImage.filter { it != deleteImageId.toInt() }
                        }) {
                            Text(text = "delete")
                        }
                    }
                    Button(onClick = {
                        navHostController.navigate("b")
                    }) {
                        Text(text = "select picture")
                    }
                    Button(onClick = {
                        coroutine.launch {
                            try {
                                val review = reviewRepository.updateReview(
                                    reviewId = reviewId.toInt(),
                                    contents = contents,
                                    rating = 3.0f,
                                    files = files,
                                    restaurantId = 10,
                                    uploadedImage = uploadedImage
                                )
                                result = GsonBuilder().setPrettyPrinting().create().toJson(review)
                            } catch (e: Exception) {
                                result = e.message.toString()
                            }
                        }
                    }) {
                        Text(text = "modReview")
                    }
                }
            }

            composable("b") {
                Box(modifier = Modifier.height(500.dp))
                {
                    gallery?.invoke(onNext = {
                        files = it
                        navHostController.popBackStack()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun UpdateReviewTest(
    reviewRepository: ReviewRepository, gallery: (@Composable (
        onNext: (List<String>) -> Unit
    ) -> Unit)? = null
) {
    val coroutine = rememberCoroutineScope()
    var contents by remember { mutableStateOf("good!") }
    var rating by remember { mutableStateOf("3.5") }
    var files: List<String> by remember { mutableStateOf(ArrayList()) }
    var restaurantId by remember { mutableStateOf("10") }
    var result by remember { mutableStateOf("") }
    val navHostController = rememberNavController()
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "UpdateReviewTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        NavHost(navController = navHostController, startDestination = "a") {
            composable("a") {
                Column {
                    Text(text = result)
                    OutlinedTextField(value = contents, onValueChange = { contents = it }, label = {
                        Text(
                            text = "contents"
                        )
                    })
                    OutlinedTextField(
                        value = restaurantId,
                        onValueChange = { restaurantId = it },
                        label = {
                            Text(text = "restaurantId")
                        })
                    OutlinedTextField(value = rating, onValueChange = { rating = it }, label = {
                        Text(text = "rating")
                    })
                    Text(text = "files : $files")
                    Button(onClick = {
                        navHostController.navigate("b")
                    }) {
                        Text(text = "select picture")
                    }
                    Button(onClick = {
                        coroutine.launch {
                            try {
                                val review = reviewRepository.addReview(
                                    contents = contents,
                                    rating = 3.0f,
                                    files = files,
                                    restaurantId = 10
                                )
                                result = GsonBuilder().setPrettyPrinting().create().toJson(review)
                            } catch (e: Exception) {
                                result = e.message.toString()
                            }
                        }
                    }) {
                        Text(text = "addReview")
                    }
                }
            }

            composable("b") {
                Box(modifier = Modifier.height(500.dp))
                {
                    gallery?.invoke(onNext = {
                        files = it
                        navHostController.popBackStack()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun GetReviewTest() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "getReview")
    }
}

@Composable
fun DeleteReviewTest(reviewRepository: ReviewRepository) {
    var reviewId by remember { mutableStateOf("10") }
    val coroutine = rememberCoroutineScope()
    Column {
        OutlinedTextField(
            value = reviewId,
            onValueChange = { reviewId = it },
            label = {
                Text(text = "reviewId")
            })
        Button(onClick = {
            coroutine.launch {

            }
        }) {
            Text(text = "deleteReview")
        }
    }
}