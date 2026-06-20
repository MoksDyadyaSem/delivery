package com.maxim.delivery.product

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Запрос на создание товара")
data class ProductRequestDTO(
    @Schema(description = "Название товара", example = "Пицца")
    val name: String,

    @Schema(description = "Цена товара в рублях", example = "500.00")
    val price: BigDecimal
)

@Schema(description = "Данные товара")
data class ProductResponseDTO(
    @Schema(description = "ID товара")
    val id: UUID,

    @Schema(description = "Название товара", example = "Пицца")
    val name: String,

    @Schema(description = "Дата и время добавления товара")
    val createdAt: LocalDateTime,

    @Schema(description = "Цена товара в рублях", example = "500.00")
    val price: BigDecimal
)
