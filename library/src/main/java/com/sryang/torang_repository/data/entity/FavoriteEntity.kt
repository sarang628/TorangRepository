package com.sryang.torang_repository.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    indices = arrayOf(
        Index(
            value = ["favorite_id"],
            unique = true
        )
    )
)
data class FavoriteEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "review_id")
    @SerializedName("review_id")
    var reviewId: Int,
    var favorite_id: Int,
    var user_id: Int,
    var create_date: String
)