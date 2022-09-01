package com.sryang.torang_repository.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AlarmEntity(
    @PrimaryKey val alarm_id: Int,
    var user_id: Int = 0,
    var other_user_id: Int = 0,
    var contents: String? = null,
    var alarm_type: Int = 0,
    var review_id: Int = 0,
    var create_date: String? = null
)