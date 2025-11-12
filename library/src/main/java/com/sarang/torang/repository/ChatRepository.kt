package com.sarang.torang.repository

import com.gmail.bishoybasily.stomp.lib.Message
import com.sarang.torang.data.ChatMessage
import com.sarang.torang.data.ChatRoom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import java.util.UUID


interface ChatRepository {
    /**
     * 채팅방 갱신
     * 채팅방, 인원, 사용자 모두 갱신
     */              suspend fun refreshAllChatRooms() : Result<Unit>
    /**
     * 채팅 가져오기
     */             suspend fun loadChats(roomId: Int)
    /**
     * 채팅방 생성
     */               suspend fun createChatRoomByUserId(userId: Int): ChatRoom
    /**
     * 채팅 가져오기
     */                     fun getChatsFlow(roomId: Int): Flow<List<ChatMessage>>
    /**
     * 채팅방 목록 가져오기
     */                fun getAllChatRoomsFlow(): Flow<List<ChatRoom>>
    /**
     * 채팅 추가
     */                suspend fun addChat(roomId: Int, message: String, uuid: String = UUID.randomUUID().toString())
    /**
     * 이미지 채팅 추가
     */           suspend fun addImageChat(roomId: Int, message: List<String>)
    /**
     * 모두 삭제
     * 채팅방 목록, 참여자 목록 , 채팅 모두 삭제
     *
     * 로그아웃 시 필요한 기능으로 추가 됨.
     */                suspend fun removeAll()
    /**
     * 채팅방 구독
     */              suspend fun subscribe(roomId: Int)
    /**
     *  STOMP 소켓 이벤트
     */                fun event(coroutineScope: CoroutineScope): Flow<Message>
    /**
     * 채팅방 구독 해제
     */                  fun unSubscribe(topic: Int)
    /**
     * 전송 실패한 이미지 갱신하기
     */  suspend fun updateFailedUploadImage(roomId: Int)
    /** 채팅방 삭제 */                 suspend fun deleteChatRoom(roomId : Int)
    /** 채팅방 참여 인원 삭제 */         suspend fun deleteParticipantsByChatRoomId(roomId : Int)
}