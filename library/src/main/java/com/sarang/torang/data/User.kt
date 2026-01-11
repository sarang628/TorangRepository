package com.sarang.torang.data

data class User(
    val userId          : Int       = -1,
    val userName        : String    = "",
    val email           : String?   = "",
    val loginPlatform   : String?   = "",
    val createDate      : String?   = "",
    val profilePicUrl   : String?   = ""
){
    companion object
}
