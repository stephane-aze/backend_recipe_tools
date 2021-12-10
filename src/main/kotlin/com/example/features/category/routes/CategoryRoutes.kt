package com.example.features.category.routes


import com.example.features.category.routes.createcategory.createCategory
import com.example.features.category.routes.getcategories.getCategories
import com.example.features.category.routes.getcategory.getCategory
import io.ktor.application.*

import io.ktor.routing.*

fun Application.categoryRoutes() {
    routing {
        getCategory()
        getCategories()
        createCategory()
    }
}