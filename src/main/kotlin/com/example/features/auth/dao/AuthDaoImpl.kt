package com.example.features.auth.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.auth.dao.mapper.fromUserDaoToUserInfo
import com.example.features.auth.dto.LoginRequestDto
import com.example.features.auth.dto.UserInfoDto
import com.example.features.auth.entity.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class AuthDaoImpl() : AuthDao {

    override fun login(request: LoginRequestDto): Boolean {
        Database.connectToExampleDatabase()

        val count:Long = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction User.select { User.email eq request.username }.count()
        }
        return count.toInt() == 1
    }

    override fun getUserInfo(email:String): UserInfoDto {
        Database.connectToExampleDatabase()

        val userInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction User.select { User.email eq email }.single().fromUserDaoToUserInfo()
        }
        return userInfo
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(User)
            User.insert {
                it[name] = userInfoDto.name
                it[surname] = userInfoDto.surname
                it[email] = userInfoDto.email
                it[password] = userInfoDto.password!!
            }
        }
    }

}