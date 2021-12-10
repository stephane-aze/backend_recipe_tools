package com.example.features.auth.dto

import com.example.features.category.dto.CategoryDto

data class UserInfoDto(val username: String, val email: String, var password: String?, val preferences: List<CategoryDto?>)