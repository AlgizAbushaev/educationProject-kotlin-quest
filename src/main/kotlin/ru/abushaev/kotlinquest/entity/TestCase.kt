package ru.abushaev.kotlinquest.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "test_cases")
data class TestCase(
    @Id
    val id: UUID = UUID.randomUUID(),
    val taskId: UUID,  // Связь с Task
    val input: String,
    val expectedOutput: String
)
