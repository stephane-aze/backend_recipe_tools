package com.example.features.category.entity

import com.example.features.auth.entity.User
import com.example.features.food.entity.Food
import org.jetbrains.exposed.sql.Table

object Category: Table("category") {
    val id = integer("id").autoIncrement()
    val name= varchar("Name",50).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}