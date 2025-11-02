package com.sarang.torang.repository

import com.gmail.bishoybasily.stomp.lib.Message
import com.sarang.torang.core.database.model.chat.ChatRoomEntity
import com.sarang.torang.core.database.model.chat.embedded.ChatMessageUserImages
import com.sarang.torang.core.database.model.chat.embedded.ChatRoomParticipants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import java.util.UUID


interface ChatRepository {
    /**
     * 채팅방 목록 가져오기
     */
    suspend fun refreshAllChatRooms()

    /**
     * 채팅 내용 가져오기
     */
    suspend fun loadContents(roomId: Int)

    /**
     * 채팅방 목록 가져오기
     */
    fun getChatRoom(): Flow<List<ChatRoomParticipants>>

    /**
     * 채팅방 목록 가져오기
     */
    fun getChatRoom1(): Flow<List<ChatRoomEntity>>

    /**
     * 채팅방 생성
     */
    suspend fun getUserOrCreateRoomByUserId(userId: Int): ChatRoomParticipants

    /**
     * 채팅 내용 가져오기
     */
    fun getContents(roomId: Int): Flow<List<ChatMessageUserImages>>

    /**
     * 채팅방 목록, 참여자 목록 가져오기
     */
    fun getAllChatRooms(): Flow<List<ChatRoomParticipants>>

    /**
     * 채팅방에 메시지 추가
     */
    suspend fun addChat(roomId: Int, message: String, uuid: String = UUID.randomUUID().toString())

    /**
     * 채팅방에 이미지 추가
     */
    suspend fun addImage(
        roomId: Int,
        message: List<String>,
        uuid: String = UUID.randomUUID().toString(),
    )

    /**
     * 채팅방 목록, 참여자 목록 , 채팅 모두 삭제
     *
     * 로그아웃 시 필요한 기능으로 추가 됨.
     */
    suspend fun removeAll()

    /**
     * 채팅방 구독
     */
    suspend fun subscribe(roomId: Int)

    /**
     *  STOMP 소켓 이벤트
     */
    fun event(coroutineScope: CoroutineScope): Flow<Message>

    /**
     * 채팅방 구독 해제
     */
    fun unSubscribe(topic: Int)

    /**
     * 전송 실패한 이미지 갱신하기
     */
    suspend fun updateFailedUploadImage(roomId: Int)
}