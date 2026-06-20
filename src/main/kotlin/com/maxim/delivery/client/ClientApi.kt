package com.maxim.delivery.client

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Клиенты", description = "Управление клиентами")
interface ClientApi {

    @Operation(
        summary = "Получить всех клиентов",
        description = "Возвращает список всех зарегистрированных клиентов"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Список клиентов успешно получен",
        content = [Content(array = ArraySchema(schema = Schema(implementation = ClientResponseDto::class)))]
    )
    fun getAllClients(): ResponseEntity<List<ClientResponseDto>>

    @Operation(
        summary = "Создать клиента",
        description = "Регистрирует нового клиента в системе"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Клиент успешно создан",
        content = [Content(schema = Schema(implementation = ClientResponseDto::class))]
    )
    fun createClient(@RequestBody clientRequestDto: ClientRequestDto): ResponseEntity<ClientResponseDto>
}
