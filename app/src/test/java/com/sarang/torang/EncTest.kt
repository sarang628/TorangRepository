package com.sarang.torang

import com.sarang.torang.di.torang_security_di.Encrypt
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EncTest {
    @Test
    fun test() {
        System.out.println(Encrypt.encrypt("Torang!234"))
    }
}