package ru.abushaev.kotlinquest.mapper

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.dto.TaskSummaryDto
import ru.abushaev.kotlinquest.dto.TaskDetailDto
import ru.abushaev.kotlinquest.entity.Task

@Service
class TaskMapper {

    fun convertTaskToDetailDto(task: Task): TaskDetailDto {
        return TaskDetailDto(
            id = task.id,
            title = task.title,
            description = task.description,
            difficulty = task.difficulty
        )
    }

    fun convertTaskToSummaryDto(task: Task): TaskSummaryDto {
        return TaskSummaryDto(
            id = task.id,
            title = task.title
        )
    }
}