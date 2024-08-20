package ru.abushaev.kotlinquest.service.impl

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.dto.TaskDetailDto
import ru.abushaev.kotlinquest.dto.TaskSummaryDto
import ru.abushaev.kotlinquest.entity.Task
import ru.abushaev.kotlinquest.mapper.TaskMapper
import ru.abushaev.kotlinquest.repository.TaskRepository
import ru.abushaev.kotlinquest.service.TaskService

@Service
class TaskServiceImpl(
    private val taskRepository: TaskRepository,
    private val taskMapper: TaskMapper
) : TaskService {
    override fun getAllTasks(): Flux<TaskSummaryDto> {
        return taskRepository.findAll()
            .map { taskMapper.convertTaskToSummaryDto(it) }
    }

    override fun getTaskById(id: Int): Mono<TaskDetailDto> {
        return taskRepository.findById(id)
            .map { taskEntity -> taskMapper.convertTaskToDetailDto(taskEntity) }
    }
}