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
import com.sryang.torang_repository.data.entity.toFeedEntity
import com.sryang.torang_repository.data.remote.response.RemoteFeed
import kotlinx.coroutines.launch
import kotlin.streams.toList

@Composable
fun FeedTestMenu(
    clickLoadByFile: () -> (Unit),
    clickDeleteAllFeed: () -> (Unit)
) {
    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    Column {
        Button(onClick = {
            clickDeleteAllFeed.invoke()
        }) {
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
        Button(onClick = {
        }) {
            Text(text = "피드 삭제하기")
        }
    }
}

fun loadFeedByFile(context: Context, fileName: String): List<FeedEntity> {
    return JsonToObjectGenerator<RemoteFeed>().getListByFile(
        context = context,
        fileName,
        RemoteFeed::class.java
    ).stream().map { it.toFeedEntity() }.toList()
}

@Composable
fun FeedRepositoryTest(context: Context, feedDao: FeedDao) {
    val scope = rememberCoroutineScope()
    Column {
        FeedTestMenu(clickLoadByFile = {
            scope.launch {
                feedDao.insertAll(loadFeedByFile(context, "plants.json"))
            }
        }, clickDeleteAllFeed = {
            scope.launch {
                feedDao.deleteAllFeed()
            }
        })
        val list by feedDao.getAllFeed().collectAsState(initial = ArrayList())
        FeedList(list = list)
    }
}

@Preview
@Composable
fun PreviewFeedTest() {
    FeedTestMenu(clickLoadByFile = {}, clickDeleteAllFeed = {})
}

@Preview
@Composable
fun PreViewFeedList() {
    FeedList(list = ArrayList())
}