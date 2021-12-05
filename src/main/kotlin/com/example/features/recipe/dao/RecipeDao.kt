package com.example.features.recipe.dao

import com.example.features.recipe.dto.RecipeDto

interface RecipeDao {
    fun createRecipe(recipeDto: RecipeDto)
    fun getRecipe(id:Long): RecipeDto
    fun getRecipes():List<RecipeDto>
}