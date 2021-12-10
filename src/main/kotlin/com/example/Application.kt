package com.example

import com.example.di.applicationModule
import com.example.features.auth.di.authModule
import com.example.features.category.di.categoryModule
import com.example.features.error.GenericServerError
import com.example.features.ingredient.di.ingredientModule
import com.example.features.recipe.di.recipeModule
import com.example.jwt.JwtManager
import io.ktor.application.*

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import foodModule
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.request.*
import io.ktor.response.*
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ktor.ext.inject
import org.slf4j.event.Level
import java.text.DateFormat


fun main(args: Array<String>) {
    //startKoin { modules(applicationModule, authModule, ingredientModule, recipeModule) }
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    startKoin { modules(applicationModule, authModule, ingredientModule, recipeModule,foodModule, categoryModule) }
    val jwtManager: JwtManager by inject()

    install(Authentication) {
        jwt {
            verifier(jwtManager.getVerifier())
            validate {
                UserIdPrincipal(it.payload.getClaim("email").asString())
            }
        }
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
            setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
            dateFormat = DateFormat.getDateInstance()
        }
    }

    install(StatusPages) {
        exception<Throwable> { cause ->
            call.response.status(HttpStatusCode.InternalServerError)
            call.respond(GenericServerError(500, cause.message.toString()))
            throw cause
        }
        exception<MissingKotlinParameterException> { cause ->
            call.respond(HttpStatusCode.BadRequest)
            throw cause
        }
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    routes()
}