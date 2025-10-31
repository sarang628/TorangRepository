package com.sarang.torang.util

interface TorangRepositoryEncrypt {
    fun encrypt(text: String): String
    fun decrypt(text: String): String
}