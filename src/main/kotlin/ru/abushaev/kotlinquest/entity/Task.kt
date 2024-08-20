package ru.abushaev.kotlinquest.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table("task", schema = "main")
data class Task(

    @Id
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val difficulty: String
)
