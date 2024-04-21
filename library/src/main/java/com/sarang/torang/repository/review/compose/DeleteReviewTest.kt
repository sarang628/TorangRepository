package com.sarang.torang.repository.review.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sarang.torang.repository.review.ReviewRepository
import kotlinx.coroutines.launch

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