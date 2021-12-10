package com.example.features.food.routes.getFoods

import com.example.extensions.parseId
import com.example.features.food.data.FoodData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getFoods() {
    val foodData: FoodData by inject()
    get("/api/food") {

        call.respond(foodData.getFoods())
    }
}