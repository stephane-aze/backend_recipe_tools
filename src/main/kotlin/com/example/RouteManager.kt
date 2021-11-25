package com.example

import com.example.features.auth.routes.authRoutes
import com.example.features.ingredient.routes.ingredientRoutes
import com.example.features.recipe.routes.recipeRoutes
import io.ktor.application.*


fun Application.routes() {
    authRoutes()
    ingredientRoutes()
    recipeRoutes()
}