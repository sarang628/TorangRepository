package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
data class LikeEntity(
    @PrimaryKey
    var likeId: Int,
    var reviewId: Int,
    var userId: Int,
    var createDate: String
)