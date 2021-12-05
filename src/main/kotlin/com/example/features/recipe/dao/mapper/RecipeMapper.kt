package com.example.features.recipe.dao.mapper


import com.example.features.recipe.dto.RecipeDto
import com.example.features.recipe.entity.Recipe
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.fromRecipeDaoToRecipeDto() = RecipeDto(
    title = this[Recipe.title],
    //unity = this[Recipe.],
    ingredients = emptyList(),
    instructions = emptyList()

)