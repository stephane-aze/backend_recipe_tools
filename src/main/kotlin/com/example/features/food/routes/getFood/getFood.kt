package com.example.features.food.routes.getFood

import com.example.extensions.parseId
import com.example.features.food.data.FoodData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
/*
fun Route.getFood() {
    val foodData: FoodData by inject()
    get("/public-api/v1/food/{id}") {
        val id = parseId()
        call.respond(foodData.getFood(id))
    }
}*/