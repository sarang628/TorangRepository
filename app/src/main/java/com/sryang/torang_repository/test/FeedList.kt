package com.sryang.torang_repository.test

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sryang.torang_repository.data.entity.FeedEntity
import com.sryang.torang_repository.data.entity.FeedEntity1


@Composable
fun FeedList(list: List<FeedEntity>) {
    Log.d("sryang123", list.toString())
    LazyColumn(content = {
        items(list.size) {
            Column {
                FeedItem(list[it])
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    })
}

@Composable
fun FeedList1(list: List<FeedEntity1>) {
    Log.d("sryang123", list.toString())
    LazyColumn(content = {
        items(list.size) {
            Column {
                //FeedItem(list[it])
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    })
}

@Preview
@Composable
fun PreviewFeedItem() {
    val feedEntity = FeedEntity(
        reviewId = 0,
        userId = 1,
        contents = "contents",
        createDate = "create_date",
        rating = 5f,
        userName = "userName",
        profilePicUrl = "profilePicUrl",
        likeAmount = 1,
        commentAmount = 2,
        restaurantName = "restaurantName",
        restaurantId = 10
    )
    FeedItem(feedEntity = feedEntity)
}


@Composable
fun FeedItem(feedEntity: FeedEntity) {
    Row {
        Column {
            Text(text = "reviewId:")
            Text(text = "userId:")
            Text(text = "isFavorite:")
            Text(text = "contents:")
            Text(text = "createDate:")
            Text(text = "rating:")
            Text(text = "userName:")
            Text(text = "profilePicUrl:")
            Text(text = "likeAmount:")
            Text(text = "commentAmount:")
            Text(text = "restaurantName:")
            Text(text = "restaurantId:")
        }
        Column(Modifier.padding(start = 5.dp)) {
            Text(text = feedEntity.reviewId.toString())
            Text(text = feedEntity.userId.toString())
            Text(text = feedEntity.contents.toString())
            Text(text = feedEntity.createDate.toString())
            Text(text = feedEntity.rating.toString())
            Text(text = feedEntity.userName.toString())
            Text(text = feedEntity.profilePicUrl.toString())
            Text(text = feedEntity.likeAmount.toString())
            Text(text = feedEntity.commentAmount.toString())
            Text(text = feedEntity.restaurantName.toString())
            Text(text = feedEntity.restaurantId.toString())
        }
    }

}