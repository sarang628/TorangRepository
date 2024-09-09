package com.sarang.torang.data.entity

data class ChatRoomWithParticipantsAndUsers(
    val chatRoomEntity: ChatRoomEntity,
    val participantsWithUsers: List<ParticipantsWithUserEntity>
)