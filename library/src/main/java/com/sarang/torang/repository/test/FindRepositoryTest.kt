package com.sarang.torang.repository.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import com.sarang.torang.repository.FindRepository
import com.sarang.torang.repository.feed.FeedRepository
import kotlinx.coroutines.launch

@Composable
fun FindRepositoryTest(findRepository: FindRepository,
                       feedLoadRepository: FeedRepository) {
    val coroutine = rememberCoroutineScope()
    val restaurants = findRepository.restaurants.collectAsState().value
    Column {
        Button({
            coroutine.launch { findRepository.search() }
        }) {}
        Text(restaurants.toString())
    }
}