package com.example.features.auth.entity

import com.example.features.category.entity.Category
import com.example.features.category.entity.Category.autoIncrement
import com.example.features.category.entity.Category.uniqueIndex
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object User : Table("user") {
    val id = integer("id").autoIncrement().uniqueIndex()
    val username = varchar("Name", 50)
    val email = varchar("Email", 50)
    val password = varchar("Password",20)

    override val primaryKey = PrimaryKey(id)
}
object PreferenceUser : Table("category_user") {
    val userId = (integer("city_id") references User.id).nullable()
    val categoryId = integer("category_id").references(Category.id).nullable()
}