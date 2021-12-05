package com.example.features.auth.dto

import com.example.features.category.dto.CategoryDto

data class RegisterRequestDto (val username: String,val email: String, val password: String, val preferences: List<CategoryDto>)

