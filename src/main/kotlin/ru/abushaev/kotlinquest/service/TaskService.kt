package ru.abushaev.kotlinquest.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.dto.TaskDetailDto
import ru.abushaev.kotlinquest.dto.TaskSummaryDto
import ru.abushaev.kotlinquest.entity.Task


interface TaskService {

    fun getAllTasks(): Flux<TaskSummaryDto>
    fun getTaskById(id: Int): Mono<TaskDetailDto>
}