package com.example.jwt

import com.auth0.jwt.JWTVerifier
import com.example.features.auth.dto.LoginRequestDto
import java.util.*

interface JwtManager {
    fun generateToken(loginRequestDto: LoginRequestDto): String
    fun getExpiration(): Date
    fun getVerifier(): JWTVerifier
    fun getUsernameFromToken(token: String?): String?
}