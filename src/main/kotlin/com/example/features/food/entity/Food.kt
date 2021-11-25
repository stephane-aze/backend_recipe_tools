package com.example.features.food.entity

import org.jetbrains.exposed.sql.Table

object Food: Table("Food") {
    val name = varchar("name",50)
    val categoryId = integer("category_id").uniqueIndex()
}