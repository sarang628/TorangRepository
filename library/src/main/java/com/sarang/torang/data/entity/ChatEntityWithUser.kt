package com.sarang.torang.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class ChatEntityWithUser(
    @Embedded
    val chatEntity: ChatEntity,
    @Relation(parentColumn = "userId", entityColumn = "userId")
    val userEntity: UserEntity,
    @Relation(parentColumn = "uuid", entityColumn = "parentUuid")
    val images: List<ChatImageEntity>,
)
