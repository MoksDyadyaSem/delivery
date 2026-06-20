package com.maxim.delivery.courier

import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CourierService(
    val courierRepository: CourierRepository,
    val courierMapper: CourierMapper
) {
    fun getAllCouriers(): List<CourierResponseDto> {
        val couriers = courierRepository.findAll()
        return couriers.map { courierMapper.toResponse(it) }
    }

    fun createCourier(courierRequestDto: CourierRequestDto): CourierResponseDto {
        val courierEntity = courierMapper.toEntity(courierRequestDto)
        val savedCourier = courierRepository.save(courierEntity)
        return courierMapper.toResponse(savedCourier)
    }

    fun findLeastBusyCourier(): Courier {
        return courierRepository.findLeastBusyCourier()
            .orElseThrow {
                RuntimeException("Courier was not found!")
            }
    }
}