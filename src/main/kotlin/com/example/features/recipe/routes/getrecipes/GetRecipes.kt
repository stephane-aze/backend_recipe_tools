package com.example.features.recipe.routes.getrecipes

import com.example.extensions.getAuthorizationTokenWithoutBearer
import com.example.features.recipe.data.RecipeData
import com.example.jwt.JwtManager
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getRecipes() {
    val recipeData: RecipeData by inject()
    val jwtManager: JwtManager by inject()
    get("/api/recipe") {
        call.respond(recipeData.getRecipes())
    }
}