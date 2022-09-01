package com.sryang.torang_core.repository

import androidx.lifecycle.LiveData
import com.sryang.torang_repository.data.entity.SearchEntity

interface SearchRepository {
    fun getHistoryKeywords(): LiveData<List<SearchEntity>>
    suspend fun saveHistory(keyword: String)
    suspend fun removeKeyword(search: SearchEntity)
}