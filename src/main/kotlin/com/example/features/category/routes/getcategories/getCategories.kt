package com.example.features.category.routes.getcategories

import com.example.extensions.parseId
import com.example.features.category.data.CategoryData
import com.example.jwt.JwtManager
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getCategories() {
    val categoryData: CategoryData by inject()
    val jwtManager: JwtManager by inject()
    get("/api/v1/category") {
        call.respond(categoryData.getCategories())
    }
}