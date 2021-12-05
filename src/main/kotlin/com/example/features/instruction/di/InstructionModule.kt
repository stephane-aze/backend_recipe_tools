package com.example.features.instruction.di


import com.example.features.instruction.dao.InstructionDao
import com.example.features.instruction.dao.InstructionDaoImpl
import com.example.features.instruction.data.InstructionData
import com.example.features.instruction.data.InstructionDataImpl
import org.koin.core.scope.get
import org.koin.dsl.bind
import org.koin.dsl.module

val instructionModule = module {
    single { InstructionDaoImpl() } bind InstructionDao::class
    single { InstructionDataImpl(get(),get()) } bind InstructionData::class
}