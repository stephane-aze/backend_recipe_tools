package com.example.features.food.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.auth.entity.PreferenceUser
import com.example.features.auth.entity.User
import com.example.features.category.dao.mapper.fromCategoryDaoToCategoryDto
import com.example.features.category.entity.Category
import com.example.features.food.dto.FoodDto
import com.example.features.food.entity.Food
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class FoodDaoImpl : FoodDao{
    override fun createFood(foodDto: FoodDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Food)
            Food.insert {
                it[name] = foodDto.name
                it[categoryId] = foodDto.category!!.id
            }
        }
    }

    /*override fun getFood(id: Long): FoodDto {
        Database.connectToExampleDatabase()

        val food = transaction {
            addLogger(StdOutSqlLogger)

            //return@transaction Category.select { Category.id eq id }.single().fromCategoryDaoToCategoryDto()
            return@transaction Food.select { Food.id eq id.toInt()  }.limit(1).single().fromFoodDaoToFoodDto()
        }
        return food
    }*/

    override fun getFoods(): List<FoodDto> {
        Database.connectToExampleDatabase()

        val foods = transaction {

            addLogger(StdOutSqlLogger)
            return@transaction Food.selectAll().map{

                val cat=it[Food.categoryId]?.let {
                    Category.select {
                        Category.id eq it
                    }.limit(1).single().fromCategoryDaoToCategoryDto()
                }
                FoodDto(
                    name = it[Food.name],
                    category =cat
                )
            }
        }
        return foods
    }
}