package com.example.features.food.entity

import com.example.features.auth.entity.PreferenceUser.references
import com.example.features.auth.entity.User
import com.example.features.category.entity.Category
import org.jetbrains.exposed.sql.Table

object Food: Table("Food") {
    var id = integer("id").uniqueIndex()
    val name = varchar("name",50)
    val categoryId = (integer("category_id") references Category.id).nullable()
    override val primaryKey = PrimaryKey(User.id)
}