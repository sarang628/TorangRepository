package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.SearchEntity
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getHistoryKeywords(): Flow<List<SearchEntity>>
    suspend fun saveHistory(keyword: String)
    suspend fun removeKeyword(search: SearchEntity)
}