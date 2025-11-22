package com.sarang.torang.repository.test

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.sarang.torang.api.handle
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.FindRepository
import kotlinx.coroutines.launch

@Composable
fun FindRepositoryTest(findRepository: FindRepository) {
    val coroutine = rememberCoroutineScope()
    val restaurants = findRepository.restaurants.collectAsState().value
    Column {
        Button({
            coroutine.launch { findRepository.search() }
        }) {}
        Text(restaurants.toString())
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FeedRepositoryTest(feedRepository: FeedRepository){
    var reviewId by remember { mutableStateOf(0) }
    val feeds by feedRepository.feeds.collectAsState(initial = ArrayList())
    var feedsByRestaurant : List<ReviewAndImageEntity> by remember { mutableStateOf(listOf()) }
    val myFeed by feedRepository.findMyFeedById(reviewId).collectAsState(initial = ArrayList())
    val coroutine = rememberCoroutineScope()
    var error by remember { mutableStateOf("") }
    var restaurantId by remember { mutableStateOf(-1) }
    LaunchedEffect(restaurantId) {
        if(restaurantId > 0){
            feedRepository.restaurantFeedsFlow(restaurantId).collect {
                feedsByRestaurant = it
            }
        }
    }
    
    FeedRepositoryTest1(
        feeds = feeds,
        myFeed = myFeed,
        feedsByRestaurant = feedsByRestaurant,
        getFeed = {
            coroutine.launch {
                try {
                    feedRepository.findAll()
                } catch (e: Exception) {
                    error = e.toString()
                }
            }
        },
        delFeed = {
            coroutine.launch { feedRepository.deleteAll() }
                  },
        addFav = {
            coroutine.launch {
                try {
                    //feedRepository.addFavorite(82)
                } catch (e: Exception) {
                    error = e.handle()
                }
            }
        },
        delFav = {
            coroutine.launch {
                //feedRepository.deleteFavorite(82)
            }
        },
        getMyFeed = {
            reviewId = 370
        },
        deleteLike = {
            coroutine.launch {
            //feedRepository.deleteLike(82)
        }
                     },
        addLike = {
            coroutine.launch {
                try {
                    //feedRepository.deleteLike(reviewId.toInt())
                } catch (e: Exception) {
                    error = e.message.toString()
                }
            }
        },
        onDeleteFeed = {
            coroutine.launch {
                feedRepository.deleteById(reviewId.toInt())
            }
        },
        onFindByPage = {
            coroutine.launch {
                feedRepository.findByPage(reviewId.toInt())
            }
        },
        onFeedByRestaurant = {
            coroutine.launch {
                feedRepository.findByRestaurantId(it)
                restaurantId = it
            }
        }
    )
}

@Preview
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FeedRepositoryTest1(
    feeds : List<ReviewAndImageEntity>? = listOf(),
    myFeed : List<ReviewAndImageEntity> = listOf(),
    feedsByRestaurant : List<ReviewAndImageEntity> = listOf(),
    getFeed : () -> Unit = {},
    delFeed : () -> Unit = {},
    addFav : () -> Unit = {},
    delFav : () -> Unit = {},
    getMyFeed : () -> Unit = {},
    deleteLike : () -> Unit = {},
    addLike : () -> Unit = {},
    onDeleteFeed : () -> Unit = {},
    onFindByPage: () -> Unit = {},
    onFeedByRestaurant: (Int) -> Unit = {}
) {

    val gson = Gson().newBuilder().setPrettyPrinting().create()
    var result by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current

    val content : @Composable () -> Unit = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
        ) {
            HorizontalDivider(color = Color.LightGray)
            Column {
                Text(text = error, color = Color.Red, fontWeight = FontWeight.Bold)
                Column {
                    Row {
                        AssistChip(onClick = getFeed, label = { Text(text = "getFeed") })
                        Spacer(Modifier.width(8.dp))
                        AssistChip(onClick = delFeed, label = { Text(text = "delFeed") })
                    }
                    Row {
                        AssistChip(onClick = addFav, label = { Text(text = "addFav") })
                        Spacer(Modifier.width(8.dp))
                        AssistChip(onClick = delFeed, label = { Text(text = "delFav") })
                    }
                    Row {
                        AssistChip(onClick = deleteLike, label = { Text(text = "deleteLike") })
                        Spacer(Modifier.width(8.dp))
                        AssistChip(onClick = getMyFeed, label = { Text(text = "GetMyFeed") })
                    }
                }
                AddLike(onAddLike = addLike) { error = it }
                DeleteFeedTest(onDeleteFeed = onDeleteFeed)
                PageFeed(onFindByPage)
                FeedByRestaurantId(onFeedByRestaurant)
            }
            Text(text = "feeds size = ${feeds?.size}")
            Text(text = "feedsByRestaurant size = ${feedsByRestaurant.size}")
            Text(text = " size = ${myFeed.size}, ${gson.toJson(myFeed)}")
            LazyColumn(content = {
                feeds?.let { feeds ->
                    items(feeds.size) {
                        Text(text = gson.toJson(feeds[it]))
                    }
                }
            })

            LazyColumn(content = {
                feedsByRestaurant.let { feeds ->
                    items(feeds.size) {
                        Text(text = gson.toJson(feeds[it]))
                    }
                }
            })

        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "FeedRepositoryTest")
                },
                navigationIcon = {
                    IconButton({
                        backPressedDispatcher?.onBackPressedDispatcher?.onBackPressed()
                    }) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, null)
                    }
                }
            )
        },
    ) {
        Box(Modifier.padding(it)){
            content()
        }
    }

}

@Preview
@Composable
fun AddLike(
    onAddLike : () -> Unit = {},
    onError: (String) -> Unit = {}
) {
    val coroutine = rememberCoroutineScope()
    var reviewId by remember { mutableStateOf("467") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.width(100.dp),
            value = reviewId,
            onValueChange = {
                try {
                    reviewId = it.toInt().toString()
                } catch (e: Exception) {

                }
            },
            label = {
                Text(text = "reviewId")
            })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = {
            coroutine.launch {
                try {
                    //feedRepository.addLike(reviewId.toInt())
                } catch (e: Exception) {
                    onError.invoke(e.handle())
                }
            }
        },
            label = { Text(text = "addLike") })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = onAddLike, label = { Text(text = "delLike") })
    }
}

@Preview
@Composable
fun DeleteFeedTest(onDeleteFeed : () -> Unit = {}) {
    var reviewId by remember { mutableStateOf("10") }
    val coroutine = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.width(100.dp),
            value = reviewId,
            onValueChange = { reviewId = it },
            label = {
                Text(text = "reviewId")
            })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = onDeleteFeed, label = {
            Text(text = "delete")
        })
    }
}

@Preview
@Composable
fun PageFeed(onFindByPage: () -> Unit = {}) {
    var reviewId by remember { mutableStateOf("1") }
    val coroutine = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.width(100.dp),
            value = reviewId,
            onValueChange = { reviewId = it },
            label = {
                Text(text = "page")
            })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = onFindByPage, label = {
            Text(text = "getFeed")
        })
    }
}

@Preview
@Composable
fun FeedByRestaurantId(onFeedByRestaurant: (Int) -> Unit = {}) {
    var restaurantId by remember { mutableStateOf("289") }
    val coroutine = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            modifier = Modifier.width(110.dp),
            value = restaurantId,
            onValueChange = { restaurantId = it },
            label = {
                Text(text = "restaurantId")
            })
        Spacer(Modifier.width(16.dp))
        AssistChip(onClick = {
            try {
                onFeedByRestaurant(restaurantId.toInt())
            }catch (e : Exception){

            }
                             }, label = {
            Text(text = "FeedByRestaurantId")
        })
    }
}