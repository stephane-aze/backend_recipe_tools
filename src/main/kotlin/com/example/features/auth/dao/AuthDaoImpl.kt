package com.example.features.auth.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.auth.dto.LoginRequestDto
import com.example.features.auth.dto.UserInfoDto
import com.example.features.auth.entity.PreferenceUser
import com.example.features.auth.entity.User
import com.example.features.category.dao.mapper.fromCategoryDaoToCategoryDto
import com.example.features.category.dto.CategoryDto
import com.example.features.category.entity.Category
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
            val user = User.select { User.email eq email }.single()
            val preferences=PreferenceUser.select {
                PreferenceUser.userId eq user[User.id]
            }
            val list =preferences.map {
                it [PreferenceUser.categoryId]?.let { res->
                    Category.select {
                        Category.id eq res
                    }.single().fromCategoryDaoToCategoryDto()
                }

            }
            return@transaction UserInfoDto(
                username = user[User.username],
                email= user[User.email],
                password = "",
                preferences = list,
            )

        }
        return userInfo
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(User,PreferenceUser)
            val userId = User.insert {

                it[username] = userInfoDto.username
                it[email] = userInfoDto.email
                it[password] = userInfoDto.password!!
            } get User.id
            print(userId)

            for (preference in userInfoDto.preferences){
                val categoryId = Category.select { Category.name eq preference!!.name }.single()[Category.id]
                PreferenceUser.insert{
                    it[PreferenceUser.userId] = userId
                    it[PreferenceUser.categoryId] = categoryId
                }

            }
        }
    }

}