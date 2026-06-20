package com.maxim.delivery.courier

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.*

@Schema(description = "Запрос на создание курьера")
data class CourierRequestDto(
    @Schema(description = "Имя курьера", example = "Александр")
    val name: String
)

@Schema(description = "Данные курьера")
data class CourierResponseDto(
    @Schema(description = "ID курьера")
    val id: UUID,

    @Schema(description = "Имя курьера", example = "Александр")
    val name: String,

    @Schema(description = "Дата и время регистрации курьера")
    val createdAt: LocalDateTime
)
