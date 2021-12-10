package com.example.features.auth.routes.loginuser

import com.example.features.auth.data.AuthData
import com.example.features.auth.dto.LoginRequestDto
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject


fun Route.loginUser() {
    val authenticationData: AuthData by inject()
    post("/auth/login") {
        val request = call.receive<LoginRequestDto>()
        call.respond(mapOf("token" to authenticationData.login(request)))
    }

}