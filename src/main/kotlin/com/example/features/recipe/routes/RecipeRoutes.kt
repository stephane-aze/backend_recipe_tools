package com.example.features.recipe.routes

//import com.selimatasoy.features.starwars.routes.getmovie.getMovie
import com.example.features.recipe.routes.createrecipe.createRecipe
import com.example.features.recipe.routes.getrecipes.getRecipes
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*

fun Application.recipeRoutes() {
    routing {
        authenticate {
            getRecipes()
            createRecipe()
        }
    }
}