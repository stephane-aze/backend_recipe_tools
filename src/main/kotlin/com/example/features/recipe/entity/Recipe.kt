package com.example.features.recipe.entity

import org.jetbrains.exposed.sql.Table

object Recipe: Table("Recipe") {
    val title = varchar("title",50)

}