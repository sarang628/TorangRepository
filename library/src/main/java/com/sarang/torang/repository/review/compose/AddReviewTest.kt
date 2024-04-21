package com.sarang.torang.repository.review.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.GsonBuilder
import com.sarang.torang.repository.review.ReviewRepository
import kotlinx.coroutines.launch

@Composable
fun AddReviewTest(
    reviewRepository: ReviewRepository, gallery: (@Composable (
        onNext: (List<String>) -> Unit
    ) -> Unit)? = null
) {
    val coroutine = rememberCoroutineScope()
    var result by remember { mutableStateOf("") }
    var isProgress by remember { mutableStateOf(false) }
    AddReviewTest(onAddReview = { contents, files, restaurantId ->
        coroutine.launch {
            try {
                isProgress = true
                val review = reviewRepository.addReview(
                    contents = contents,
                    rating = 3.0f,
                    files = files,
                    restaurantId = restaurantId?.toInt()
                )
                result = GsonBuilder().setPrettyPrinting().create().toJson(review)
            } catch (e: Exception) {
                result = e.message.toString()
            } finally {
                isProgress = false
            }
        }
    }, gallery = gallery, isProgress = isProgress, result = result)
}


@Composable
fun AddReviewTest(
    onAddReview: ((
        contents: String,
        files: List<String>,
        restaurantId: String?
    ) -> Unit)? = null,
    gallery: (@Composable (
        onNext: (List<String>) -> Unit
    ) -> Unit)? = null,
    error: String? = null,
    isProgress: Boolean = false,
    result: String? = null
) {
    var contents by remember { mutableStateOf("good!") }
    var rating by remember { mutableStateOf("3.5") }
    var files: List<String> by remember { mutableStateOf(ArrayList()) }
    var restaurantId: String? by remember { mutableStateOf(null) }
    val navHostController = rememberNavController()
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "AddReviewTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        if (isProgress) CircularProgressIndicator()
        error?.let { Text(text = it) }
        NavHost(navController = navHostController, startDestination = "a") {
            composable("a") {
                Column {
                    result?.let { Text(text = it) }
                    OutlinedTextField(value = contents, onValueChange = { contents = it }, label = {
                        Text(
                            text = "contents"
                        )
                    })
                    OutlinedTextField(
                        value = restaurantId ?: "",
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
                        onAddReview?.invoke(contents, files, restaurantId)
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

@Preview
@Composable
fun PreviewAddReviewTest() {
    AddReviewTest()
}