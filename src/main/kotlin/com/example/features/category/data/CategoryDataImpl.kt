package com.example.features.category.data

import com.example.features.category.dao.CategoryDao
import com.example.features.category.dto.CategoryDto
import com.example.jwt.JwtManager

class CategoryDataImpl(private val categoryDao: CategoryDao, private val jwtManager: JwtManager): CategoryData {
    override fun createCategory(request: CategoryDto) {
        return categoryDao.createCategory(request)
    }

    override fun getCategory(id: Long): CategoryDto {
        return categoryDao.getCategoryById(id)
    }

    override fun getCategories(): List<CategoryDto> {
        return categoryDao.getCategories()
    }
}