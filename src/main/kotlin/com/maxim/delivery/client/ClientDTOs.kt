package com.maxim.delivery.client

import java.time.LocalDateTime
import java.util.UUID

data class ClientRequestDto(
    val name: String
)

data class ClientResponseDto(
    val id: UUID,
    val name: String,
    val createdAt: LocalDateTime
)