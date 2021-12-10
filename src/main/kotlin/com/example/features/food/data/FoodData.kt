package com.example.features.food.data

import com.example.features.food.dto.FoodDto

interface FoodData {
    fun createFood(foodDto: FoodDto)
    //fun getFood(id: Long): FoodDto
    fun getFoods(): List<FoodDto>
}