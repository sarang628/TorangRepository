package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 */
@Entity
data class ChatEntity(
    @PrimaryKey(autoGenerate = true) var _id: Int = -1,
    val roomId: Int,
    val userId: Int,
    val message: String,
    val createDate: String,
)
