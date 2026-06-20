package com.maxim.delivery.courier

import java.time.LocalDateTime
import java.util.*

data class CourierRequestDto(val name: String)

data class CourierResponseDto(
    val id: UUID,
    val name: String,
    val createdAt: LocalDateTime
)