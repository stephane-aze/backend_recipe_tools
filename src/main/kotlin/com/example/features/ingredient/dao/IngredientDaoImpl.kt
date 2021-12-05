package com.example.features.ingredient.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.ingredient.dao.mapper.fromIngredientDaoToIngredientDto
import com.example.features.ingredient.dto.IngredientDto
import com.example.features.ingredient.entity.Ingredient
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class IngredientDaoImpl: IngredientDao {
    override fun getIngredient(): IngredientDto {
        Database.connectToExampleDatabase()

        val ingredient = transaction {
            addLogger(StdOutSqlLogger)
            //return@transaction Category.select { Category.id eq id }.single().fromCategoryDaoToCategoryDto()
            return@transaction Ingredient.select { Ingredient.id eq id.toInt()  }.limit(1).single().fromIngredientDaoToIngredientDto()
        }
        return ingredient
    }

    override fun getIngredients(): List<IngredientDto> {
        Database.connectToExampleDatabase()

        val ingredients = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction Ingredient.selectAll().map{it.fromIngredientDaoToIngredientDto()}
        }
        return ingredients
    }

    override fun createIngredient(ingredientDto: IngredientDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Ingredient)
            Ingredient.insert {
                it[quantity] = ingredientDto.quantity
                it[unity] = ingredientDto.unity
            }
        }
    }
}