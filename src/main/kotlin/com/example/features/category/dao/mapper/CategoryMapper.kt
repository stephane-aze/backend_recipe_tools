package com.example.features.category.dao.mapper

import com.example.features.category.dto.CategoryDto
import com.example.features.category.entity.Category
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.fromCategoryDaoToCategoryDto() = CategoryDto(
    name = this[Category.name],
    id = this[Category.id]


)