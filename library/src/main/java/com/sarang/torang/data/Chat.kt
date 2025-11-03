package com.sarang.torang.data


data class ChatMessage(
    val id          : Int = 0,
    val uuid        : String,
    val roomId      : Int,
    val userId      : Int,
    val message     : String,
    val createDate  : String,
    val sending     : Boolean,
    val user: User,
    val images: List<ChatImage>,
)

data class ChatRoom(
    val roomId: Int,
    val createDate: String,
    val chatParticipants: List<User>,
)

data class ChatImage(
    val parentUuid: String,
    val uuid: String,
    val roomId: Int,
    val userId: Int,
    val localUri: String,
    val url: String,
    val createDate: String,
    val uploadedDate: String,
    val sending: Boolean,
    val failed: Boolean,
)