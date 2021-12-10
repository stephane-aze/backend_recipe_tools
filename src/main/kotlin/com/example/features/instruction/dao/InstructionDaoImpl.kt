package com.example.features.instruction.dao

import com.example.extensions.connectToExampleDatabase
import com.example.features.instruction.dao.mapper.fromInstructionDaoToInstructionDto
import com.example.features.instruction.dto.InstructionDto
import com.example.features.instruction.entity.Instruction
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class InstructionDaoImpl: InstructionDao {
    override fun getInstruction(id: Long): InstructionDto {
        Database.connectToExampleDatabase()

        val instruction = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction Instruction.select{ Instruction.id eq id.toInt() }.single().fromInstructionDaoToInstructionDto()
        }

        return instruction

    }

    override fun getInstructions(): List<InstructionDto> {
        Database.connectToExampleDatabase()

        val instructions = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction Instruction.selectAll().map { it.fromInstructionDaoToInstructionDto() }
        }

        return instructions
    }

    override fun createIntruction(instructionDto: InstructionDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Instruction)
            Instruction.insert {
                it[stepNumber] = instructionDto.stepNumber
                it[description] = instructionDto.description
            }
        }
    }
}