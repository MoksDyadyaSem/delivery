package com.maxim.delivery.order

import com.maxim.delivery.courier.CourierResponseDto
import com.maxim.delivery.product.ProductResponseDTO
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.*

@Schema(description = "Запрос на создание заказа")
data class OrderRequestDto(
    @Schema(description = "Список ID товаров", example = "[\"uuid1\", \"uuid2\"]")
    val productIds: List<UUID>,

    @Schema(description = "ID клиента, оформляющего заказ", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    val clientId: UUID
)

@Schema(description = "Данные заказа")
data class OrderResponseDto(
    @Schema(description = "ID заказа")
    val id: UUID,

    @Schema(description = "Назначенный курьер (null если ещё не назначен)")
    val deliveredBy: CourierResponseDto?,

    @Schema(description = "Дата и время создания заказа")
    val createdAt: LocalDateTime,

    @Schema(description = "Список товаров в заказе")
    val productList: List<ProductResponseDTO>,

    @Schema(description = "Текущий статус заказа")
    var status: OrderStatus
)
