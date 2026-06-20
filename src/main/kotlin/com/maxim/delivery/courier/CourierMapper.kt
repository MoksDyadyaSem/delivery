package com.maxim.delivery.courier

import org.springframework.stereotype.Component

@Component
class CourierMapper {
    fun toEntity(courierRequestDto: CourierRequestDto): Courier {
        return Courier(
            name = courierRequestDto.name,
            ordersToDeliver = mutableListOf()
        )
    }

    fun toResponse(courier: Courier): CourierResponseDto {
        return CourierResponseDto(
            id = courier.id!!,
            name = courier.name,
            createdAt = courier.createdAt!!
        )
    }
}