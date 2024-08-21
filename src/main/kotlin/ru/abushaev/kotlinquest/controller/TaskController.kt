package ru.abushaev.kotlinquest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.converter.StringToUUIDConverter
import ru.abushaev.kotlinquest.dto.TaskDetailDto
import ru.abushaev.kotlinquest.dto.TaskSummaryDto
import ru.abushaev.kotlinquest.service.TaskCheckService
import ru.abushaev.kotlinquest.service.TaskService
import java.util.UUID

@RestController
@RequestMapping("api/task")
class TaskController(
    private val taskService: TaskService,
    private val taskCheckService: TaskCheckService,
    private val converter: StringToUUIDConverter
) {

    @GetMapping
    fun getAllTasks(): Flux<TaskSummaryDto> = taskService.getAllTasks()

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: String): Mono<TaskDetailDto> = taskService.getTaskById(converter.convert(id))

    @PostMapping("/{id}/check-solution")
    fun getCheckSolution(
        @PathVariable id: UUID,
        @RequestBody solution: String
    ): Mono<ResponseEntity<Boolean>> {
        return taskCheckService.checkSolution(id, solution)
            .map { isCorrect ->
                if (isCorrect) {
                    ResponseEntity.ok(isCorrect)
                } else {
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isCorrect)
                }
            }
            .onErrorResume { Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(false))
            }
    }
}