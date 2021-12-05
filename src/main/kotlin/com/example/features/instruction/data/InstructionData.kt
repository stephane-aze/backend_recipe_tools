package com.example.features.instruction.data

import com.example.features.instruction.dto.InstructionDto

interface InstructionData {
    fun getInstruction(id:Long):InstructionDto
    fun getInstructions():List<InstructionDto>
    fun createIntruction(instructionDto: InstructionDto)
}