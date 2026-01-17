package com.sarang.torang.repository.test.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sarang.torang.data.FavoriteAndImage
import com.sarang.torang.data.ReviewAndImage
import com.sarang.torang.repository.feed.FeedFlowRepository
import com.sarang.torang.repository.feed.FeedLoadRepository
import com.sarang.torang.repository.feed.FeedRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FeedRepositoryTestScreen(feedRepository: FeedRepository,
                             feedLoadRepository: FeedLoadRepository,
                             feedFlowRepository: FeedFlowRepository){
    var reviewId by remember { mutableStateOf(0) }
    val feeds by feedLoadRepository.feeds.collectAsState(initial = ArrayList())
    var feedsByRestaurant : List<ReviewAndImage> by remember { mutableStateOf(listOf()) }
    val myFeed by feedFlowRepository.findMyFeedById(reviewId).collectAsState(initial = ArrayList())
    val coroutine = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }
    var restaurantId by remember { mutableStateOf("") }
    val favoriteFlow : List<FavoriteAndImage> by feedFlowRepository.findByFavoriteFlow().collectAsStateWithLifecycle(listOf())
    var restaurantFeedsFlow : List<ReviewAndImage> by remember { mutableStateOf(listOf()) }

    LaunchedEffect(restaurantId) {
        try {
            feedFlowRepository.findRestaurantFeedsFlow(restaurantId.toInt())
                              .stateIn(scope = coroutine,
                                       started = SharingStarted.Eagerly,
                                       initialValue = listOf()).collect {
                    restaurantFeedsFlow = it
                }
        }catch (e: Exception){

        }
    }

    LaunchedEffect(restaurantId) {
        try{
            if(restaurantId.toInt() > 0){
                feedFlowRepository.findRestaurantFeedsFlow(restaurantId.toInt()).collect {
                    feedsByRestaurant = it
                }
            }
        }catch (e : Exception){

        }

    }
    
    FeedRepositoryTest1(
        feeds = feeds,
        favoriteFlow = favoriteFlow,
        message = message,
        loadByFavorite = { coroutine.launch {
            try {
                feedLoadRepository.loadByFavorite()
            }catch (e : Exception){
                message = e.message ?: ""
            }
        } },
        feedLoadRepository = feedLoadRepository,
        feedRepository = feedRepository,
        feedFlowRepository = feedFlowRepository,
        restaurantId = restaurantId,
        onRestaurantId = { restaurantId = it },
        restaurantFeedsFlow = restaurantFeedsFlow
    )
}
@Preview(showBackground = true)
@Composable
fun Menu(
    restaurantFeedsFlow: () -> Unit = {},
    restaurantId       : String     = "",
    onRestaurantId     : (String) -> Unit  = {},
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
    onSearch: () -> Unit = {},
    message : String = "",
){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Row {
            AssistChip(restaurantFeedsFlow  , label = {Text("restaurantFeedsFlow: ")
                                                                BasicTextField(value = restaurantId,
                                                                               onValueChange = onRestaurantId,
                                                                               maxLines = 1)})
            Text(restaurantId)
        }
        AssistChip(findByPictureIdFlow  , label = {Text("findByPictureIdFlow") })
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
        AssistChip(onSearch             , label = {Text("onSearch")})
    }
}