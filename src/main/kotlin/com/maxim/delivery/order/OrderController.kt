package com.maxim.delivery.order

import com.maxim.delivery.deliveryManagement.DeliveryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    val orderService: OrderService,
    val deliveryService: DeliveryService
) : OrderApi {

    override fun getAllOrders(): ResponseEntity<List<OrderResponseDto>> {
        val orders = orderService.getAllOrders()
        return ResponseEntity.ok(orders)
    }

    override fun createOrder(@RequestBody orderRequestDto: OrderRequestDto): ResponseEntity<OrderResponseDto> {
        val orderToSave = deliveryService.createAndPublishOrder(orderRequestDto)
        return ResponseEntity.ok(orderToSave)
    }
}
