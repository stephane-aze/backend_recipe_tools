package com.example


import com.example.features.auth.routes.authRoutes
import com.example.features.category.routes.categoryRoutes
import com.example.features.food.routes.foodRoutes
import com.example.features.ingredient.routes.ingredientRoutes
import com.example.features.recipe.routes.recipeRoutes
import com.example.plugins.configureRouting
import io.ktor.application.*


fun Application.routes() {
    configureRouting()
    authRoutes()
    ingredientRoutes()
    recipeRoutes()
    categoryRoutes()
    foodRoutes()
}