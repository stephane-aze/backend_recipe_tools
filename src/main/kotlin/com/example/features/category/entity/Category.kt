package com.example.features.category.entity

import com.example.features.food.entity.Food
import org.jetbrains.exposed.sql.Table

object Category: Table("category") {
    val categoryId = integer("category_id")
        .uniqueIndex()
        .references(Food.categoryId)
    val name= varchar("Name",50)
}