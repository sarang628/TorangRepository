package com.sarang.torang.repository.test.chat

import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ChatTab(pagerState : PagerState){
    val coroutine = rememberCoroutineScope()
    PrimaryTabRow(selectedTabIndex = pagerState.currentPage) {
        Tab(selected = pagerState.currentPage == 0, onClick = {
            coroutine.launch {
                pagerState.animateScrollToPage(0)
            }
        }) {
            TextButton(onClick = {
                coroutine.launch {
                    pagerState.animateScrollToPage(0)
                }
            }) {
                Text(text = "ChatRoom")
            }

        }
        Tab(selected = pagerState.currentPage == 1, onClick = {
            coroutine.launch {
                pagerState.animateScrollToPage(1)
            }
        }) {
            TextButton(onClick = {
                coroutine.launch {
                    pagerState.animateScrollToPage(1)
                }
            }) {
                Text(text = "Chat")
            }
        }
    }
}