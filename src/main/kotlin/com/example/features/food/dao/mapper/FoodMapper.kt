package com.example.features.food.dao.mapper



import com.example.features.food.dto.FoodDto
import com.example.features.food.entity.Food
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.fromFoodDaoToFoodDto() = FoodDto(
    name = this[Food.name],

    //id = this[Food.id]

)