package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 */
@Entity(indices = [Index(value = ["userId", "createDate"], unique = true)])
data class ChatEntity(
    @PrimaryKey(autoGenerate = true) var _id: Int = 0,
    val roomId: Int,
    val userId: Int,
    val message: String,
    val createDate: String,
)
