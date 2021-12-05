package com.example.features.recipe.data

import com.example.features.food.dao.FoodDao
import com.example.features.recipe.dao.RecipeDao
import com.example.features.recipe.dto.RecipeDto
import com.example.jwt.JwtManager

class RecipeDataImpl(private val recipeDao: RecipeDao, private val jwtManager: JwtManager):RecipeData {
    override fun createRecipe(recipeDto: RecipeDto) {
        recipeDao.createRecipe(recipeDto)
    }

    override fun getRecipe(id: Long) {
        recipeDao.getRecipe(id)
    }

    override fun getRecipes() {
        recipeDao.getRecipes()
    }
}