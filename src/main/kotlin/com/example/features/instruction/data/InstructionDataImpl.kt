package com.example.features.instruction.data

import com.example.features.food.dao.FoodDao
import com.example.features.instruction.dao.InstructionDao
import com.example.features.instruction.dto.InstructionDto
import com.example.jwt.JwtManager

class InstructionDataImpl(private val instructionDao: InstructionDao, private val jwtManager: JwtManager):InstructionData {
    override fun getInstruction(id: Long): InstructionDto {
        TODO("Not yet implemented")
    }

    override fun getInstructions(): List<InstructionDto> {
        TODO("Not yet implemented")
    }

    override fun createIntruction(instructionDto: InstructionDto) {
        TODO("Not yet implemented")
    }
}