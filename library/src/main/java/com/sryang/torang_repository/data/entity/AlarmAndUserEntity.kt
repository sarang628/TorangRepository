package com.sryang.torang_repository.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class AlarmAndUserEntity(
    @Embedded val alarm: AlarmEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "userId"
    )
    val user: UserEntity?,
    @Relation(
        parentColumn = "other_user_id",
        entityColumn = "userId"
    )
    val another: UserEntity?

)