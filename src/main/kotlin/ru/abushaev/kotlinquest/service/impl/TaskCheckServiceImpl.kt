package ru.abushaev.kotlinquest.service.impl

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import ru.abushaev.kotlinquest.exception.TaskNotFoundException
import ru.abushaev.kotlinquest.repository.TaskRepository
import ru.abushaev.kotlinquest.repository.TestCaseRepository
import ru.abushaev.kotlinquest.service.TaskCheckService
import java.io.File
import java.util.*

@Service
class TaskCheckServiceImpl(
    private val taskRepository: TaskRepository,
    private val codeExecutionServiceImpl: CodeExecutionServiceImpl,
    private val testCaseRepository: TestCaseRepository
) : TaskCheckService {

    override fun checkSolution(taskId: UUID, userSolution: String): Mono<Boolean> {
        return taskRepository.findById(taskId)
            .switchIfEmpty(Mono.error(TaskNotFoundException("Task by id: $taskId not found")))
            .flatMap { task ->
                testCaseRepository.findByTaskId(task.id)
                    .collectList()
                    .flatMap { testCases ->
                        Flux.fromIterable(testCases)
                            .flatMap { testCase ->
                                executeUserCode(userSolution, testCase.input)
                                    .map { output -> output == testCase.expectedOutput }
                            }
                            .all { it }
                    }
            }
    }


    fun executeUserCode(userSolution: String, input: String): Mono<String> {
        val solutionFile = saveUserSolutionToFile(userSolution)
        return codeExecutionServiceImpl.execute(solutionFile.path, input)
    }

    private fun saveUserSolutionToFile(userSolution: String): File {
        val solutionFile = File.createTempFile("UserSolution", ".java")
        solutionFile.writeText(userSolution)
        return solutionFile
    }


}