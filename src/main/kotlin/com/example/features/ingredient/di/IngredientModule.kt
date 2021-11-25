package com.example.features.ingredient.di

import com.example.features.auth.dao.AuthDao
import com.example.features.auth.dao.AuthDaoImpl
import com.example.features.auth.data.AuthData
import com.example.features.auth.data.AuthDataImpl
import com.example.http.HttpService
import com.example.http.HttpServiceImpl
import com.example.jwt.JwtManager
import com.example.jwt.JwtManagerImpl
import com.typesafe.config.ConfigFactory
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module


val ingredientModule = module {
    single { AuthDaoImpl() } bind AuthDao::class
    single { AuthDataImpl(get(),get()) } bind AuthData::class
}