package com.example.features.food.routes


import com.example.features.food.routes.createFood.createFood

import com.example.features.food.routes.getFoods.getFoods
import io.ktor.application.*
import io.ktor.routing.*

fun Application.foodRoutes() {
    routing {
       // getFood()
        getFoods()
        createFood()
    }
}