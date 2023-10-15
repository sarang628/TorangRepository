package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(indices = [Index(value = ["favoriteId"], unique = true)])
data class FavoriteEntity(
    @PrimaryKey
    var reviewId: Int,
    var favoriteId: Int,
    var userId: Int,
    var createDate: String
)