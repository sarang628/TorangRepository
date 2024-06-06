package com.sarang.torang.data

import com.google.gson.annotations.SerializedName
import com.sarang.torang.data.remote.response.RemoteUser

data class RemoteAlarm(
    @SerializedName("alarm_id")
    val alarmId: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("other_user_id")
    val otherUserId: Int,
    val contents: String,
    @SerializedName("alarm_type")
    val alarmType: String,
    @SerializedName("review_id")
    val reviewId: Int,
    @SerializedName("create_date")
    val createDate: String,
    val user: RemoteUser,
    val otherUser: RemoteUser,
    @SerializedName("picture_url")
    val pictureUrl: String,
)