package com.maxim.delivery.order

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Статус заказа: CREATED → ASSIGNED → IN_PROGRESS → DELIVERED")
enum class OrderStatus {
    CREATED,
    ASSIGNED,
    IN_PROGRESS,
    DELIVERED
}
