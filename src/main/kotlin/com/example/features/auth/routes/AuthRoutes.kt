package com.example.features.auth.routes



import com.example.features.auth.routes.createuser.createUser
import com.example.features.auth.routes.loginuser.loginUser
import com.example.features.auth.routes.userinfo.userInfo
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*

fun Application.authRoutes() {
    routing {
        loginUser()
        authenticate {
            userInfo()
        }
        createUser()
    }
}