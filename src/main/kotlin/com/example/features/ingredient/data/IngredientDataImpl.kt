package com.example.features.ingredient.data

import com.example.features.food.dao.FoodDao
import com.example.features.ingredient.dao.IngredientDao
import com.example.features.ingredient.dto.IngredientDto
import com.example.jwt.JwtManager

class IngredientDataImpl(private val ingredientDao: IngredientDao, private val jwtManager: JwtManager): IngredientData {
    override fun getIngredient(): IngredientDto {
        return ingredientDao.getIngredient()
    }

    override fun getIngredients(): List<IngredientDto> {
        TODO("Not yet implemented")
    }

    override fun createIngredient(ingredientDto: IngredientDto) {
        TODO("Not yet implemented")
    }
}