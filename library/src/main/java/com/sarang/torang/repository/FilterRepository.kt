package com.sarang.torang.repository

import com.sarang.torang.data.Distances
import com.sarang.torang.data.Filter
import com.sarang.torang.data.Prices
import kotlinx.coroutines.flow.Flow

interface FilterRepository {
    /** 현재 필터 상태 */
    fun getCurrentFilter(): Flow<Filter>
    /** 음식 종류 선택 */
    suspend fun selectRestaurantType(food: String)
    /** 가격대 선택 */
    suspend fun selectPrice(price: Prices)
    /** 평점 선택 */
    suspend fun selectRatings(ratings: String)
    /** 거리 선택 */
    suspend fun selectDistance(distances: Distances)
    /** 현재 필터 값 얻기 */
    suspend fun getFilter(): Filter
}