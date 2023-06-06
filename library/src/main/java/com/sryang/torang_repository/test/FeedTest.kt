package com.sryang.torang_repository.test

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.library.JsonToObjectGenerator
import com.sryang.torang_repository.data.dao.FeedDao
import com.sryang.torang_repository.data.entity.FeedEntity
import kotlinx.coroutines.launch

@Composable
fun FeedTest(
    clickLoadByFile: () -> (Unit),
    clickDeleteAllFeed: () -> (Unit)
) {
    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    Column {
        Button(onClick = {}) {
            Text(text = "모든 피드 삭제하기")
        }
        Button(onClick = {
            scope.launch {
                clickLoadByFile.invoke()
            }
        }) {
            Text(text = "피드 파일로 불러오기")
        }
        Button(onClick = {}) {
            Text(text = "피드 API로 불러오기")
        }
        Button(onClick = {}) {
            Text(text = "피드 추가하기")
        }
        Button(onClick = {}) {
            Text(text = "피드 추가하기")
        }
        Button(onClick = {
            clickDeleteAllFeed.invoke()
        }) {
            Text(text = "피드 삭제하기")
        }
    }
}

fun loadFeedByFile(context: Context): List<FeedEntity> {
    return JsonToObjectGenerator<FeedEntity>().getListByFile(
        context = context,
        "plants.json",
        FeedEntity::class.java
    )
}

@Composable
fun FeedTest1(context: Context, feedDao: FeedDao) {
    val scope = rememberCoroutineScope()
    Column {
        FeedTest(clickLoadByFile = {
            scope.launch {
                feedDao.insertAll(loadFeedByFile(context = context))
            }
        },
            clickDeleteAllFeed = {
                scope.launch {
                    feedDao.deleteAllFeed()
                }
            }
        )

        val listFlow = feedDao.getMyFeed(0)
        val list by listFlow.collectAsState(initial = ArrayList())
        FeedList(list = list)
    }
}

@Preview
@Composable
fun PreviewFeedTest() {
}