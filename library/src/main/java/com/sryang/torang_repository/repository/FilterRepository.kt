package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.Distances
import com.sryang.torang_repository.data.Filter
import com.sryang.torang_repository.data.Prices
import com.sryang.torang_repository.data.Ratings
import com.sryang.torang_repository.data.RestaurantType
import kotlinx.coroutines.flow.Flow

interface FilterRepository {
    /** 현재 필터 상태 */
    fun getCurrentFilter(): Flow<Filter>
    /** 음식 종류 선택 */
    suspend fun selectRestaurantType(food: RestaurantType)
    /** 가격대 선택 */
    suspend fun selectPrice(price: Prices)
    /** 평점 선택 */
    suspend fun selectRatings(ratings: Ratings)
    /** 거리 선택 */
    suspend fun selectDistance(distances: Distances)
    /** 현재 필터 값 얻기 */
    suspend fun getFilter(): Filter
}