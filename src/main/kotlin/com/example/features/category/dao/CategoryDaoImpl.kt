package com.example.features.category.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.category.dao.mapper.fromCategoryDaoToCategoryDto

import com.example.features.category.dto.CategoryDto
import com.example.features.category.entity.Category
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class CategoryDaoImpl: CategoryDao{
    override fun createCategory(categoryDto: CategoryDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Category)
            Category.insert {
                it[name] = categoryDto.name
            }
        }
    }

    override fun getCategoryById(id: Long): CategoryDto {
        Database.connectToExampleDatabase()

        val category = transaction {
            addLogger(StdOutSqlLogger)
            //return@transaction Category.select { Category.id eq id }.single().fromCategoryDaoToCategoryDto()
            return@transaction Category.select { Category.id eq id.toInt()  }.limit(1).single().fromCategoryDaoToCategoryDto()
        }
        return category
    }

    override fun getCategories(): List<CategoryDto> {
        Database.connectToExampleDatabase()

        val categories = transaction {
            addLogger(StdOutSqlLogger)
            //return@transaction Category.select { Category.id eq id }.single().fromCategoryDaoToCategoryDto()
            return@transaction Category.selectAll().map { it.fromCategoryDaoToCategoryDto() }
        }
        return categories
    }
}