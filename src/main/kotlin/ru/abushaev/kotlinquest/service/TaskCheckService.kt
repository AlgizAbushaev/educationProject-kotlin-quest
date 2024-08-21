package ru.abushaev.kotlinquest.service

import reactor.core.publisher.Mono
import java.util.*

interface TaskCheckService {

    fun checkSolution(taskId: UUID, userSolution: String): Mono<Boolean>
}