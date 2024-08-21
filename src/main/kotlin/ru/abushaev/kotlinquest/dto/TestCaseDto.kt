package ru.abushaev.kotlinquest.dto

import java.io.Serializable

/**
 * DTO for {@link ru.abushaev.kotlinquest.entity.TestCase}
 */
data class TestCaseDto(val input: String? = null, val expectedOutput: String? = null) : Serializable