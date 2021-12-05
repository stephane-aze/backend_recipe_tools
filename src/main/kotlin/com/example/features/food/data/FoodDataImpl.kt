package com.example.features.food.data

import com.example.features.category.dao.CategoryDao
import com.example.features.food.dao.FoodDao
import com.example.features.food.dto.FoodDto
import com.example.jwt.JwtManager

class FoodDataImpl(private val foodDao: FoodDao, private val jwtManager: JwtManager) : FoodData{
    override fun createFood(foodDto: FoodDto) {
        return foodDao.createFood(foodDto)
    }

    override fun getFood(id: Long): FoodDto {
        return foodDao.getFood(id)
    }

    override fun getFoods(): List<FoodDto> {
        return foodDao.getFoods()
    }
}