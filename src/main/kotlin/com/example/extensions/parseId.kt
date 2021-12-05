package com.example.extensions

import io.ktor.application.*
import io.ktor.util.pipeline.*

fun PipelineContext<Unit, ApplicationCall>.parseId(): Long {
    return try {
        call.parameters["id"]?.toLong() ?: throw Exception(
            "Id parameter can't be null"
        )
    } catch (e: NumberFormatException) {
        throw Exception("Id parameter is invalid")
    }
}