package com.maxim.delivery.order

import com.maxim.delivery.deliveryManagement.DeliveryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    val orderService: OrderService,
    val deliveryService: DeliveryService
) {
    @GetMapping
    fun getAllOrders(): ResponseEntity<List<OrderResponseDto>> {
        val orders = orderService.getAllOrders()
        return ResponseEntity.ok(orders)
    }

    @PostMapping
    fun createOrder(@RequestBody orderRequestDto: OrderRequestDto): ResponseEntity<OrderResponseDto> {
        val orderToSave = deliveryService.createOrder(orderRequestDto)
        return ResponseEntity.ok(orderToSave)
    }
}