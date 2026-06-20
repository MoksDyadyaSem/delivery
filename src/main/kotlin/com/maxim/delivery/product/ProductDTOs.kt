package com.maxim.delivery.product

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class ProductRequestDTO(
    val name: String,
    val price: BigDecimal
)

data class ProductResponseDTO(
    val id: UUID,
    val name: String,
    val createdAt: LocalDateTime,
    val price: BigDecimal
)