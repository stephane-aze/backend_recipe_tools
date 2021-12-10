package com.example.features.recipe.routes.createrecipe

import com.example.features.recipe.data.RecipeData
import com.example.features.auth.dto.UserInfoDto
import com.example.features.recipe.dto.RecipeDto
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.createRecipe() {
    val recipeData: RecipeData by inject()
    post("/api/recipe") {
        recipeData.createRecipe(call.receive<RecipeDto>())
        call.respond(HttpStatusCode.OK)
    }
}