package com.sryang.torang_repository.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class FeedEntity1(
    @Embedded val user: FeedEntity,
    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val reviewImages: List<ReviewImageEntity>
)