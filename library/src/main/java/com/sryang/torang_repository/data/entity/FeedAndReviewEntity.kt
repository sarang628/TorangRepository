package com.sryang.torang_repository.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class FeedAndReviewEntity(
    @Embedded val user: FeedEntity,
    @Relation(
        parentColumn = "reviewId",
        entityColumn = "reviewId"
    )
    val reviewImages: List<ReviewImageEntity>
)