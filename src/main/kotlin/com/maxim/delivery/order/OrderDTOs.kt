package com.maxim.delivery.order

import com.maxim.delivery.courier.CourierResponseDto
import com.maxim.delivery.product.ProductResponseDTO
import java.time.LocalDateTime
import java.util.*

// при создании заказа мы только отправляем список продуктов + заказчика
data class OrderRequestDto(
    val productIds: List<UUID>,
    val clientId: UUID
)

data class OrderResponseDto(
    val id: UUID,
    val deliveredBy: CourierResponseDto?,
    val createdAt: LocalDateTime,
    val productList: List<ProductResponseDTO>
)