package com.example.features.food.entity

import org.jetbrains.exposed.sql.Table

object Food: Table("Food") {
    var id = integer("id").uniqueIndex()
    val name = varchar("name",50)
    val categoryId = integer("category_id").uniqueIndex()
}