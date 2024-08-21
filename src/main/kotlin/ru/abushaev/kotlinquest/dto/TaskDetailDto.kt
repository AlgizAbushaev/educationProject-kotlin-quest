package ru.abushaev.kotlinquest.dto

import java.util.*

data class TaskDetailDto(
    val id: UUID,
    val title: String,
    val description: String,
    val difficulty: String,
    val testCases: List<TestCaseDto>
)
