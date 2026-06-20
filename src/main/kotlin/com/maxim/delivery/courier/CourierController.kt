package com.maxim.delivery.courier

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/couriers")
class CourierController(
    val courierService: CourierService
) {
    @GetMapping
    fun getAllClients(): ResponseEntity<List<CourierResponseDto>> {
        val couriers = courierService.getAllCouriers()
        return ResponseEntity.ok(couriers)
    }

    @PostMapping
    fun createCourier(@RequestBody courierRequestDto: CourierRequestDto): ResponseEntity<CourierResponseDto> {
        val courierToCreate = courierService.createCourier(courierRequestDto)
        return ResponseEntity.ok(courierToCreate)
    }
}