package com.example.di

import com.example.http.HttpService
import com.example.http.HttpServiceImpl
import com.example.jwt.JwtManager
import com.example.jwt.JwtManagerImpl
import com.typesafe.config.ConfigFactory
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module


val applicationModule = module {
    single { JwtManagerImpl(get(qualifier = named("jwtSecretProperty"))) } bind JwtManager::class
    single(named("jwtSecretProperty")) { ConfigFactory.load().getString("jwt.secret").toString() }
    factory { HttpServiceImpl() } bind HttpService::class
}