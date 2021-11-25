package com.example.features.auth.dao

import com.example.features.auth.dto.LoginRequestDto
import com.example.features.auth.dto.UserInfoDto

interface AuthDao {
    fun login(request: LoginRequestDto): Boolean
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}