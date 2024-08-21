package ru.abushaev.kotlinquest.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.entity.Task
import java.util.*

@Repository
interface TaskRepository: R2dbcRepository<Task, Int> {
    fun findById(taskId: UUID): Mono<Task>
}