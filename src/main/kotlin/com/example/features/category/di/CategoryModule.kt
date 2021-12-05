package com.example.features.category.di

import com.example.features.category.dao.CategoryDao
import com.example.features.category.dao.CategoryDaoImpl
import com.example.features.category.data.CategoryData
import com.example.features.category.data.CategoryDataImpl
import org.koin.core.scope.get
import org.koin.dsl.bind
import org.koin.dsl.module

val categoryModule = module {
    single { CategoryDaoImpl() } bind CategoryDao::class
    single { CategoryDataImpl(get(),get()) } bind CategoryData::class
}