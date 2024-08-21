package ru.abushaev.kotlinquest.service.impl

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import ru.abushaev.kotlinquest.entity.ExecutionRequest

@Service
class CodeExecutionServiceImpl(private val webClient: WebClient) {

    fun execute(solutionFilePath: String, input: String): Mono<String> {

        val request = ExecutionRequest(solutionFilePath, input)

        return webClient.post()
            .uri("")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(String::class.java)

    }
}