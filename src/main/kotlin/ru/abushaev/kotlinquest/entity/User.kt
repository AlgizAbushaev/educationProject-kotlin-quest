package ru.abushaev.kotlinquest.entity

data class User(

    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val role: String
)
