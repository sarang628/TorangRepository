package com.sryang.torang_repository.test

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sryang.torang_repository.data.entity.FeedEntity


@Composable
fun FeedList(list: List<FeedEntity>) {
    Log.d("sryang123", list.toString())
    LazyColumn(content = {
        items(list.size) {
            Text(text = list[it].toString(), Modifier.height(100.dp))
        }
    })
}

