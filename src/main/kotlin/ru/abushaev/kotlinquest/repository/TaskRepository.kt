package ru.abushaev.kotlinquest.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import ru.abushaev.kotlinquest.entity.Task

@Repository
interface TaskRepository: ReactiveCrudRepository<Task, Int> {
}