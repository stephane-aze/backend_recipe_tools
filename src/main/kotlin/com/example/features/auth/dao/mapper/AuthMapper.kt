package com.example.features.auth.dao.mapper

import com.example.features.auth.dto.UserInfoDto
import com.example.features.auth.entity.User
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.fromUserDaoToUserInfo() = UserInfoDto(
    email = this[User.email],
    name = this[User.name],
    surname = this[User.surname],
    password = ""
)