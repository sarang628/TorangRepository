package com.sryang.torang_repository.test

import com.sryang.torang_core.data.entity.Feed
import com.sryang.torang_repository.data.remote.response.Response
import com.sryang.torang_repository.repository.FeedRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestFeedRepositoryImpl @Inject constructor() : FeedRepository {
    override suspend fun deleteFeed(reviewId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun loadFeed(): Response<List<Feed>> {
        return Response(400)
        /*return ArrayList<RemoteFeed>().apply {
            add(
                RemoteFeed(
                    name = "sryang",
                    reviewId = 0,
                    restaurantName = "스타벅스",
                    rating = 5.0f,
                    profilePictureUrl = "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                    reviewImages = arrayListOf(
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/"
                    )
                )
            )
            add(
                RemoteFeed(
                    name = "제니",
                    reviewId = 1,
                    restaurantName = "맥도날드",
                    rating = 5.0f,
                    profilePictureUrl = "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                    reviewImages = arrayListOf(
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/"
                    )
                )
            )
            add(
                RemoteFeed(
                    "리사",
                    reviewId = 2,
                    restaurantName = "도스타코스",
                    rating = 5.0f,
                    profilePictureUrl = "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                    reviewImages = arrayListOf(
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/"
                    )
                )
            )
            add(
                RemoteFeed(
                    "지수",
                    reviewId = 3,
                    restaurantName = "스시마이우",
                    rating = 5.0f,
                    profilePictureUrl = "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                    reviewImages = arrayListOf(
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/"
                    )
                )
            )
            add(
                RemoteFeed(
                    "로제",
                    reviewId = 4,
                    restaurantName = "매드포갈릭",
                    rating = 5.0f,
                    profilePictureUrl = "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                    reviewImages = arrayListOf(
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/",
                        "https://thumb.mt.co.kr/06/2022/01/2022011414312292328_1.jpg/dims/optimize/"
                    )
                )
            )
        }*/
    }
}