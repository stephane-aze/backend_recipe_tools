package com.example.features.recipe.dto

import com.example.features.ingredient.dto.IngredientDto
import com.example.features.instruction.dto.InstructionDto
import com.example.features.instruction.entity.Instruction

data class RecipeDto(val title: String,val ingredients: List<IngredientDto>,val instructions: List<InstructionDto>)
