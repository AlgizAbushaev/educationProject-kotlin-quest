package ru.abushaev.kotlinquest.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import ru.abushaev.kotlinquest.entity.TestCase
import java.util.UUID

@Repository
interface TestCaseRepository: R2dbcRepository<TestCase, UUID> {
    fun findByTaskId(taskId: UUID): Flux<TestCase>
}