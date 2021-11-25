package com.example.features.ingredient.entity

import com.example.features.food.entity.Food.uniqueIndex
import org.jetbrains.exposed.sql.Table

object Ingredient: Table("Ingredient") {
    val productId = integer("product_id").uniqueIndex()
    val quantity = float("quantity")
    val unity = varchar("unity",10)
    val recipeId = integer("recipe_id").uniqueIndex()
}