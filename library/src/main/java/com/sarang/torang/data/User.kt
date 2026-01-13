package com.sarang.torang.data

data class User(
    val userId          : Int       = -1,
    val userName        : String    = "",
    val email           : String?   = "",
    val loginPlatform   : String?   = "",
    val createDate      : String?   = "",
    val profilePicUrl   : String?   = "",
    val post            : Int       = 0,
    val following       : Int       = 0,
    val follower        : Int       = 0,
    val follow          : Int       = 0
){
    companion object
}
