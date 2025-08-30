package com.sarang.torang.repository

import com.sarang.torang.core.database.model.search.SearchEntity
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getHistoryKeywords(): Flow<List<SearchEntity>>
    suspend fun saveHistory(keyword: String)
    suspend fun removeKeyword(search: SearchEntity)
}