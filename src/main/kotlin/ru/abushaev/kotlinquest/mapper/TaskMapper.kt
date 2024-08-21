package ru.abushaev.kotlinquest.mapper

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.dto.TaskSummaryDto
import ru.abushaev.kotlinquest.dto.TaskDetailDto
import ru.abushaev.kotlinquest.dto.TestCaseDto
import ru.abushaev.kotlinquest.entity.Task
import ru.abushaev.kotlinquest.entity.TestCase

@Service
class TaskMapper {

    fun convertTaskToDetailDto(task: Task, testCases: List<TestCase>): TaskDetailDto {
        return TaskDetailDto(
            id = task.id,
            title = task.title,
            description = task.description,
            difficulty = task.difficulty,
            testCases = testCases.map { convertTestCaseToDto(it) }
        )
    }

    private fun convertTestCaseToDto(testCase: TestCase): TestCaseDto {
        return TestCaseDto(
            input = testCase.input,
            expectedOutput = testCase.expectedOutput
        )
    }

    fun convertTaskToSummaryDto(task: Task): TaskSummaryDto {
        return TaskSummaryDto(
            id = task.id,
            title = task.title
        )
    }
}