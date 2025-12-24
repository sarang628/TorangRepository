package com.sarang.torang.repository.test.feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sarang.torang.data.ReviewAndImage

@Preview(showBackground = true)
@Composable
fun RestaurantFeedsFlow(feeds : List<ReviewAndImage>? = listOf()){
    LazyColumn(Modifier.fillMaxSize()) {
        feeds?.let {
            items(it){
                Text("reviewId: ${it.review.reviewId}")
                Text("userId: ${it.review.userId}")
                Text("userName: ${it.review.userName}")
                Text(it.review.contents ?: "")
                HorizontalDivider()
            }
        }
    }
}