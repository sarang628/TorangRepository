package com.sarang.torang.repository.test.feed

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.data.FavoriteAndImage
import com.sarang.torang.data.ReviewAndImage
import com.sarang.torang.repository.feed.FeedLoadRepository

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FeedRepositoryTest1(
    feeds : List<ReviewAndImage>? = listOf(),
    favoriteFlow : List<FavoriteAndImage> = listOf(),
    message : String = "",
    loadByFavorite: () -> Unit = {},
    feedLoadRepository : FeedLoadRepository
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
                        findByFavoriteFlow = { navigation.navigate("findByFavoriteFlow") },
                        loadByPage = { navigation.navigate("loadByPage") }
                    )
                }
                composable("restaurantFeedsFlow") {
                    RestaurantFeedsFlow(feeds)
                }

                composable("findByFavoriteFlow"){
                    FindByFavoriteFlow(favoriteFlow)
                }

                composable("loadByPage"){
                    LoadByPage(feedLoadRepository = feedLoadRepository)
                }
            }
        }
    }
}