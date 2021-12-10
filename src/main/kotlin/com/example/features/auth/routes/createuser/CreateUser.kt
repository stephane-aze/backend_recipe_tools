package com.example.features.auth.routes.createuser

import com.example.features.auth.data.AuthData
import com.example.features.auth.dto.UserInfoDto
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.createUser() {
    val authData: AuthData by inject()
    post("/api/auth/createUser") {

        authData.createUser(call.receive())
        call.respond(HttpStatusCode.OK)
    }
}