package com.sarang.torang.repository

import com.sarang.torang.data.Search
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getHistoryKeywords(): Flow<List<Search>>
    suspend fun saveHistory(keyword: String)
    suspend fun removeKeyword(search: Search)
}