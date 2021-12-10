package com.example.features.food.routes.createFood

import com.example.features.category.data.CategoryData
import com.example.features.category.dto.CategoryDto
import com.example.features.food.data.FoodData
import com.example.features.food.dto.FoodDto
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.createFood() {
    val foodData: FoodData by inject()
    post("/api/food") {
        foodData.createFood(call.receive<FoodDto>())
        call.respond(HttpStatusCode.OK)
    }
}