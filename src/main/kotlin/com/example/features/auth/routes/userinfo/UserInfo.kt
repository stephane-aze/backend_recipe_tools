package com.example.features.auth.routes.userinfo


import com.example.extensions.getAuthorizationTokenWithoutBearer
import com.example.features.auth.data.AuthData
import com.example.jwt.JwtManager

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
//import com.example.extensions.

fun Route.userInfo() {
    val authenticationData: AuthData by inject()
    val jwtManager: JwtManager by inject()
    get("/auth/userInfo") {
        call.respond(authenticationData.getUserInfo(jwtManager.getUsernameFromToken(call.getAuthorizationTokenWithoutBearer())!!))
    }
}