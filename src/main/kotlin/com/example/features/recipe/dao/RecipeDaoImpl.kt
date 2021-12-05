package com.example.features.recipe.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.recipe.dao.mapper.fromRecipeDaoToRecipeDto
import com.example.features.recipe.dto.RecipeDto
import com.example.features.recipe.entity.Recipe
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class RecipeDaoImpl:RecipeDao {
    override fun createRecipe(recipeDto: RecipeDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Recipe)
            Recipe.insert {
                it[title] = recipeDto.title

            }
        }
    }

    override fun getRecipe(id: Long): RecipeDto {
        Database.connectToExampleDatabase()

        val recipes = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction Recipe.select{ Recipe.id eq id.toInt()}.single().fromRecipeDaoToRecipeDto()
        }
        return recipes
    }

    override fun getRecipes(): List<RecipeDto> {
        Database.connectToExampleDatabase()

        val recipes = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction Recipe.selectAll().map{it.fromRecipeDaoToRecipeDto()}
        }
        return recipes
    }
}