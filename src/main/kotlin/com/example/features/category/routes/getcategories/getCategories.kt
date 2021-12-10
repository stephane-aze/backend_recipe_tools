package com.example.features.category.routes.getcategories

import com.example.features.category.data.CategoryData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getCategories() {
    val categoryData: CategoryData by inject()
    //val jwtManager: JwtManager by inject()
    get("/api/category") {
        call.respond(categoryData.getCategories())
    }
}