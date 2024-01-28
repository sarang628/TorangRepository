package com.sarang.torang.data

import com.google.gson.annotations.SerializedName
import com.sarang.torang.data.remote.response.RemoteUser

data class RemoteAlarm(
    @SerializedName("alarm_id")
    var alarmId: Int,
    @SerializedName("user_id")
    var userId: Int,
    @SerializedName("other_user_id")
    var otherUserId: Int,
    var contents: String,
    @SerializedName("alarm_type")
    var alarmType: String,
    @SerializedName("review_id")
    var reviewId: Int,
    @SerializedName("create_date")
    var createDate: String,
    var user: RemoteUser,
    var otherUser: RemoteUser
)