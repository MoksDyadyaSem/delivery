package com.maxim.delivery.courier

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/couriers")
class CourierController(
    val courierService: CourierService
) : CourierApi {

    override fun getAllCouriers(): ResponseEntity<List<CourierResponseDto>> {
        val couriers = courierService.getAllCouriers()
        return ResponseEntity.ok(couriers)
    }

    override fun createCourier(@RequestBody courierRequestDto: CourierRequestDto): ResponseEntity<CourierResponseDto> {
        val courierToCreate = courierService.createCourier(courierRequestDto)
        return ResponseEntity.ok(courierToCreate)
    }
}
