package com.sarang.torang

data class Follower(
    val followerId: Int,
    val userName: String,
    val profilePicUrl: String,
    val isFollow: Int
){
    companion object
}
