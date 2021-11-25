package com.example.features.auth.data

import com.example.features.auth.dto.LoginRequestDto
import com.example.features.auth.dto.UserInfoDto

interface AuthData {
    fun login(request: LoginRequestDto): String
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}