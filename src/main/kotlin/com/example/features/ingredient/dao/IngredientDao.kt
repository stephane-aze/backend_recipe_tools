package com.example.features.ingredient.dao

import com.example.features.ingredient.dto.IngredientDto

interface IngredientDao {
    fun getIngredient(): IngredientDto
    fun getIngredients(): List<IngredientDto>
    fun createIngredient(ingredientDto: IngredientDto)
}