package com.sarang.torang.repository.test.feed

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sarang.torang.data.FavoriteAndImage

@Preview
@Composable
fun FindByFavoriteFlow(
    favoriteFlow : List<FavoriteAndImage> = listOf(),
){
    Log.d("__findByFavoriteFlow","${favoriteFlow.size}")
    LazyColumn {
        items(favoriteFlow){
            Text(it.toString())
        }
    }
}
