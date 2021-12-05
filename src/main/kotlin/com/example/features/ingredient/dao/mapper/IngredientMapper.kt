package com.example.features.ingredient.dao.mapper


import com.example.features.ingredient.dto.IngredientDto
import com.example.features.ingredient.entity.Ingredient
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.fromIngredientDaoToIngredientDto() = IngredientDto(
    quantity = this[Ingredient.quantity],
    unity = this[Ingredient.unity],
    //unity = this[Ingredient.],
    //id = this[Ingredient.id]

)