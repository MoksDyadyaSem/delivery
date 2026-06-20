package com.maxim.delivery.client

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Запрос на создание клиента")
data class ClientRequestDto(
    @Schema(description = "Имя клиента", example = "Максим")
    val name: String
)

@Schema(description = "Данные клиента")
data class ClientResponseDto(
    @Schema(description = "ID клиента")
    val id: UUID,

    @Schema(description = "Имя клиента", example = "Максим")
    val name: String,

    @Schema(description = "Дата и время регистрации клиента")
    val createdAt: LocalDateTime
)
