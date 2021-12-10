package com.example.features.auth.data

import com.example.features.auth.dao.AuthDao
import com.example.features.auth.dto.LoginRequestDto
import com.example.features.auth.dto.UserInfoDto

import com.example.jwt.JwtManager

class AuthDataImpl(private val authenticationDao: AuthDao, private val jwtManager: JwtManager) :
    AuthData {
    override fun login(request: LoginRequestDto): String {
        if (authenticationDao.login(request)) {
            return jwtManager.generateToken(request)
        } else {
            throw Exception("There is no such user")
        }
    }

    override fun getUserInfo(email: String): UserInfoDto {
        return authenticationDao.getUserInfo(email).apply { password = null }
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        print(userInfoDto)
        return authenticationDao.createUser(userInfoDto)
    }
}