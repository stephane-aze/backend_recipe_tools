package com.example.features.instruction.dao

import com.example.features.instruction.dto.InstructionDto

interface InstructionDao {
    fun getInstruction(id:Long): InstructionDto
    fun getInstructions():List<InstructionDto>
    fun createIntruction(instructionDto: InstructionDto)
}