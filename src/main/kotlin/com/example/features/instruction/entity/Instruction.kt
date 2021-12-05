package com.example.features.instruction.entity

import org.jetbrains.exposed.sql.Table

object Instruction: Table("Instruction") {
    val id = integer("id").uniqueIndex()
    val stepNumber = integer("stepNumber")
    val description = varchar("description",1000)
}