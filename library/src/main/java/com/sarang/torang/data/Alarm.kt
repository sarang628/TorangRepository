package com.sarang.torang.data


data class Alarm(
    val alarmId: Int,
    val userId: Int,
    val otherUserId: Int,
    val contents: String,
    val alarmType: String,
    val reviewId: Int,
    val createDate: String,
    val user: User,
    val otherUser: User,
    val pictureUrl: String,
){
    companion object
}