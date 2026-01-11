package com.sarang.torang.repository

import com.sarang.torang.Follower

interface FollowRepository {
    suspend fun getMyFollower(): List<Follower>
    suspend fun getFollower(userId: Int): List<Follower>
    suspend fun getMyFollowing(): List<Follower>
    suspend fun getFollowing(userId: Int): List<Follower>
    suspend fun follow(userId: Int): Boolean
    suspend fun unFollow(userId: Int): Boolean
    suspend fun delete(userId: Int): Boolean
}