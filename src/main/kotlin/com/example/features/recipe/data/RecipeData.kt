package com.example.features.recipe.data

import com.example.features.recipe.dto.RecipeDto

interface RecipeData {
    fun createRecipe(recipeDto: RecipeDto)
    fun getRecipe(id:Long)
    fun getRecipes()
}