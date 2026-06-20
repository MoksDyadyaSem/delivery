package com.maxim.delivery.client

import org.springframework.stereotype.Component

@Component
class ClientMapper {
    fun toEntity(clientRequestDto: ClientRequestDto): Client {
        return Client(
            name = clientRequestDto.name
        )
    }

    fun toResponse(client: Client): ClientResponseDto {
        return ClientResponseDto(
            id = client.id!!,
            name = client.name,
            createdAt = client.createdAt!!
        )
    }
}