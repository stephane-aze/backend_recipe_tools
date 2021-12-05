package com.example.features.category.data


import com.example.features.category.dto.CategoryDto


interface CategoryData {
    fun createCategory(request: CategoryDto)
    fun getCategory(id: Long): CategoryDto
    fun getCategories(): List<CategoryDto>
}