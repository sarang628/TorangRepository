package com.sryang.torang_repository.repository

import com.sryang.torang_repository.data.entity.SearchEntity
import kotlinx.coroutines.flow.StateFlow

interface SearchRepository {
    fun getHistoryKeywords(): StateFlow<List<SearchEntity>>
    suspend fun saveHistory(keyword: String)
    suspend fun removeKeyword(search: SearchEntity)
}