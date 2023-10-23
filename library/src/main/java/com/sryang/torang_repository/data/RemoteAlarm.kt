package com.sryang.torang_repository.data

data class RemoteAlarm(
    var alarmId: Int,
    var userId: Int,
    var otherUserId: Int,
    var contents: String,
    var alarmType: String,
    var reviewId: Int,
    var createDate: String,
    var user: User,
    var otherUser: User
)