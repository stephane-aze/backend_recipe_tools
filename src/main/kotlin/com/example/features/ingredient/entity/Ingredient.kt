package com.example.features.ingredient.entity

import org.jetbrains.exposed.sql.Table

object Ingredient: Table("Ingredient") {
    val id = integer("id").uniqueIndex()
    val productId = integer("product_id").uniqueIndex()
    val quantity = float("quantity")
    val unity = varchar("unity",10)
    val recipeId = integer("recipe_id").uniqueIndex()
}