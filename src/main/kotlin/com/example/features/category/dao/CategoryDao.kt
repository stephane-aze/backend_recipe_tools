package com.example.features.category.dao

import com.example.features.category.dto.CategoryDto

interface CategoryDao {
    fun createCategory(categoryDto: CategoryDto)
    fun getCategoryById(id: Long): CategoryDto
    fun getCategories(): List<CategoryDto>
}