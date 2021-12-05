package com.example.features.ingredient.data

import com.example.features.ingredient.dto.IngredientDto

interface IngredientData {
    fun getIngredient(): IngredientDto
    fun getIngredients(): List<IngredientDto>
    fun createIngredient(ingredientDto: IngredientDto)
}