package com.example.features.instruction.dao.mapper

import com.example.features.ingredient.dto.IngredientDto
import com.example.features.instruction.dto.InstructionDto
import com.example.features.instruction.entity.Instruction
import com.example.features.recipe.dto.RecipeDto
import com.example.features.recipe.entity.Recipe
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.fromInstructionDaoToInstructionDto() = InstructionDto(
    stepNumber = this[Instruction.stepNumber],
    //unity = this[Recipe.],
    description = this[Instruction.description]


)