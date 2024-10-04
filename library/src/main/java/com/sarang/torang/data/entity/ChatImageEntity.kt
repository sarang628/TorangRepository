package com.sarang.torang.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * @param sending 전송중
 */
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ChatEntity::class,
            parentColumns = ["uuid"],
            childColumns = ["parentUuid"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ChatImageEntity(
    @PrimaryKey(autoGenerate = true) var _id: Int = 0,
    val parentUuid: String,
    val uuid: String,
    val roomId: Int,
    val userId: Int,
    val localUri: String,
    val url: String,
    val createDate: String,
    val uploadedDate: String,
    val sending: Boolean,
)
