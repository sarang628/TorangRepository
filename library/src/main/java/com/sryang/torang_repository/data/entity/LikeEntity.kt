package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(indices = arrayOf(Index(value = ["like_id"],
        unique = true)))
data class LikeEntity constructor(
        @PrimaryKey
        var like_id: Int,
        @ColumnInfo(name = "review_id")
        @SerializedName("review_id")
        var reviewId: Int,
        var user_id: Int,
        var create_date: String?
)