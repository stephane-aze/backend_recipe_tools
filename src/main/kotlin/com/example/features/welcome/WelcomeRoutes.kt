package com.example.features.welcome

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.welcomeRoutes() {
    routing {
        get ("/") {
            call.respondText("Hello, world!")
        }
    }
}