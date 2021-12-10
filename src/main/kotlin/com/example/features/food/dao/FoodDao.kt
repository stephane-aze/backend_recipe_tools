package com.example.features.food.dao

import com.example.features.food.dto.FoodDto

interface FoodDao {
    fun createFood(foodDto: FoodDto)
    //fun getFood(id: Long): FoodDto
    fun getFoods(): List<FoodDto>
}