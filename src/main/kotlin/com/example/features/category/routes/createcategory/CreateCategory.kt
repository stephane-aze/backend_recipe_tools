package com.example.features.category.routes.createcategory

import com.example.features.auth.data.AuthData
import com.example.features.auth.dto.UserInfoDto
import com.example.features.category.data.CategoryData
import com.example.features.category.dto.CategoryDto
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.createCategory() {
    val categoryData: CategoryData by inject()
    post("/public-api/v1/category") {
        categoryData.createCategory(call.receive<CategoryDto>())
        call.respond(HttpStatusCode.OK)
    }
}