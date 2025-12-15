package com.sarang.torang.data

import java.text.SimpleDateFormat
import kotlin.random.Random

data class Comment(
    val commentId: Int = Random.nextInt(0,Integer.MAX_VALUE),
    val userId: Int,
    val profilePicUrl: String,
    val userName: String,
    val comment: String,
    val reviewId: Int,
    val createDate: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()),
    val commentLikeId: Int? = null,
    val commentLikeCount: Int = 0,
    val tagUserId: Int? = null,
    val subCommentCount: Int? = null,
    val parentCommentId: Int? = null,
    val isUploading: Boolean = false,
){
    companion object
}
