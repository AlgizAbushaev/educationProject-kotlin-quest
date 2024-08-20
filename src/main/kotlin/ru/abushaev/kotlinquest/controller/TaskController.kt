package ru.abushaev.kotlinquest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.dto.TaskDetailDto
import ru.abushaev.kotlinquest.dto.TaskSummaryDto
import ru.abushaev.kotlinquest.entity.Task
import ru.abushaev.kotlinquest.service.TaskService

@RestController
@RequestMapping("api/task")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(): Flux<TaskSummaryDto> = taskService.getAllTasks()

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Int): Mono<TaskDetailDto> = taskService.getTaskById(id)
}