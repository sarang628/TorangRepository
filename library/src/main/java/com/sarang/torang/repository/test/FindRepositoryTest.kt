package com.sarang.torang.repository.test

import android.util.Log
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.GsonBuilder
import com.sarang.torang.api.handle
import com.sarang.torang.core.database.model.favorite.FavoriteAndImageEntity
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.repository.FeedRepository
import com.sarang.torang.repository.FindRepository
import kotlinx.coroutines.flow.Flow
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
    var message by remember { mutableStateOf("") }
    var restaurantId by remember { mutableStateOf(-1) }
    val favoriteFlow : List<FavoriteAndImageEntity> by feedRepository.findByFavoriteFlow().collectAsStateWithLifecycle(listOf())

    LaunchedEffect(restaurantId) {
        if(restaurantId > 0){
            feedRepository.restaurantFeedsFlow(restaurantId).collect {
                feedsByRestaurant = it
            }
        }
    }
    
    FeedRepositoryTest1(
        feeds = feeds,
        favoriteFlow = favoriteFlow,
        message = message,
        loadByFavorite = { coroutine.launch {
            try {
                feedRepository.loadByFavorite()
            }catch (e : Exception){
                message = e.message ?: ""
            }
        } }
    )
}

@Preview
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FeedRepositoryTest1(
    feeds : List<ReviewAndImageEntity>? = listOf(),
    favoriteFlow : List<FavoriteAndImageEntity> = listOf(),
    message : String = "",
    loadByFavorite: () -> Unit = {},
) {
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current
    val navigation = rememberNavController()

    Scaffold(
        contentWindowInsets = WindowInsets(left = 8.dp, right = 8.dp),
        topBar = {
            TopAppBar(title = { Text(text = "FeedRepositoryTest") },
                     navigationIcon = {
                         IconButton( onClick = { backPressedDispatcher?.onBackPressedDispatcher?.onBackPressed() }) {
                                                 Icon(Icons.AutoMirrored.Default.ArrowBack, null) }})
                 },
    ) {
        Box(Modifier.padding(it)){
            NavHost(navController = navigation, startDestination = "menu"){
                composable("menu"){
                    Menu(
                        restaurantFeedsFlow = { navigation.navigate("restaurantFeedsFlow") },
                        loadByFavorite = loadByFavorite,
                        message = message,
                        findByFavoriteFlow = { navigation.navigate("findByFavoriteFlow") }
                    )
                }
                composable("restaurantFeedsFlow") {
                    restaurantFeedsFlow(feeds)
                }

                composable("findByFavoriteFlow"){
                    findByFavoriteFlow(favoriteFlow)
                }
            }
        }
    }
}

@Preview
@Composable
fun findByFavoriteFlow(
    favoriteFlow : List<FavoriteAndImageEntity> = listOf(),
){
    Log.d("__findByFavoriteFlow","${favoriteFlow.size}")
    LazyColumn {
        items(favoriteFlow){
            Text(it.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun restaurantFeedsFlow(feeds : List<ReviewAndImageEntity>? = listOf()){
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

@Preview(showBackground = true)
@Composable
private fun Menu(
    restaurantFeedsFlow: () -> Unit = {},
    findByPictureIdFlow: () -> Unit = {},
    findById: () -> Unit = {},
    findMyFeedById: () -> Unit = {},
    findByUserIdFlow: () -> Unit = {},
    findByFavoriteFlow: () -> Unit = {},
    findByLikeFlow: () -> Unit = {},
    findAllUserFeedById: () -> Unit = {},
    findByPictureId: () -> Unit = {},
    loadAll: () -> Unit = {},
    loadByUserId: () -> Unit = {},
    loadById: () -> Unit = {},
    loadByPage: () -> Unit = {},
    loadByRestaurantId: () -> Unit = {},
    loadByFavorite: () -> Unit = {},
    loadByLike: () -> Unit = {},
    deleteAll: () -> Unit = {},
    deleteById: () -> Unit = {},
    getReviewImages: () -> Unit = {},
    message : String = "",
){
    Column {
        HorizontalDivider(color = Color.LightGray)
        Column {
            Text(text = message, color = Color.Red, fontWeight = FontWeight.Bold)
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                AssistChip(restaurantFeedsFlow  , label = {Text("restaurantFeedsFlow")})
                AssistChip(findByPictureIdFlow  , label = {Text("findByPictureIdFlow")})
                AssistChip(findById             , label = {Text("findById")})
                AssistChip(findMyFeedById       , label = {Text("findMyFeedById")})
                AssistChip(findByUserIdFlow     , label = {Text("findByUserIdFlow")})
                AssistChip(findByFavoriteFlow   , label = {Text("findByFavoriteFlow")})
                AssistChip(findByLikeFlow       , label = {Text("findByLikeFlow")})
                AssistChip(findAllUserFeedById  , label = {Text("findAllUserFeedById")})
                AssistChip(findByPictureId      , label = {Text("findByPictureId")})
                AssistChip(loadByUserId         , label = {Text("loadByUserId")})
                AssistChip(loadById             , label = {Text("loadById")})
                AssistChip(loadByPage           , label = {Text("loadByPage")})
                AssistChip(loadByRestaurantId   , label = {Text("loadByRestaurantId")})
                AssistChip(loadByFavorite       , label = {Text("loadByFavorite")})
                AssistChip(loadByLike           , label = {Text("loadByLike")})
                AssistChip(deleteAll            , label = {Text("deleteAll")})
                AssistChip(deleteById           , label = {Text("deleteById")})
                AssistChip(getReviewImages      , label = {Text("getReviewImages")})
            }
        }
    }
}

@Preview(showBackground = true)
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

@Preview(showBackground = true)
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

@Preview(showBackground = true)
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

@Preview(showBackground = true)
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